package org.sanal.srp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM sanal.users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM sanal.user_roles WHERE username=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/lib/**", "/images/**", "/open/**", "/global/**", "/fonts/**",
		"/js/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/resources/**", "/signup", "/about").permitAll()
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll().failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/login?logout")
				.deleteCookies("JSESSIONID").invalidateHttpSession(true)
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and().csrf();
	}
}