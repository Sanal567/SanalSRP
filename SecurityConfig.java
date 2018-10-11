package org.sanal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sanal567 Date 11-10-18 7:22 PM
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM sanal.users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM sanal.user_roles WHERE username=?");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()
					.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN'")
					.and()
						.formLogin().loginPage("/login").failureUrl("/login?error")
						.usernameParameter("username").passwordParameter("password")
					.and()
						.logout().logoutSuccessUrl("/login?logout")
					.and()
						.exceptionHandling().accessDeniedPage("/403")
					.and()
						.csrf();
	}

}
