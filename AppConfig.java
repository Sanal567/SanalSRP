package org.sanal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author sanal567 Date 11-10-18 7:36 PM
 */

@Import({ SecurityConfig.class })
@ComponentScan({ "org.sanal.web.*" })
@EnableWebMvc
@Configuration
public class AppConfig {

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		driverManagerDataSource.setUsername("postgres");
		driverManagerDataSource.setPassword("kjhgfdsa");
		return driverManagerDataSource;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
