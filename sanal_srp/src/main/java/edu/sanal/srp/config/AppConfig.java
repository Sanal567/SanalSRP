package edu.sanal.srp.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * This configuration class configures the persistence layer of application and
 * enables annotation driven transaction management.
 *
 * This configuration is put to a single class because this way we can write integration
 * tests for our persistence layer by using the configuration used by our example
 * application. In other words, we can ensure that the persistence layer of our application
 * works as expected.
 *
 * @author sanal567 Date 14-10-18 10:58 PM
 */


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories(basePackages = { "org.sanal.srp.entities" })
@ComponentScan({ "org.sanal.srp.web.*" })
@Import({ SecurityConfig.class })
public class AppConfig {

	@Autowired
	private Environment env;

    /**
     * Creates and configures the HikariCP datasource bean.
     * @param env   The runtime environment of  our application.
     * @return
     */
	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSourceConfig.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSourceConfig.setUsername(env.getProperty("jdbc.username"));
		dataSourceConfig.setPassword(env.getProperty("jdbc.password"));
		return new HikariDataSource(dataSourceConfig);
	}

    /**
     * Creates the bean that creates the JPA entity manager factory.
     * @param dataSource    The datasource that provides the database connections.
     * @param env           The runtime environment of  our application.
     * @return
     */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("org.sanal.srp.entities");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
		jpaProperties.put("hibernate.ejb.naming_strategy", env.getProperty("hibernate.ejb.naming_strategy"));
		 //If the value of this property is true, Hibernate will use prettyprint
        //when it writes SQL to the console.
		jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	/**
     * Creates the transaction manager bean that integrates the used JPA provider with the
     * Spring transaction mechanism.
     * @param entityManagerFactory  The used JPA entity manager factory.
     * @return {@link JpaTransactionManager}
     */
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

// @Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/global/**").addResourceLocations("/resources/");
//		registry.addResourceHandler("/images/**/*").addResourceLocations("resources/images/");
//		registry.addResourceHandler("/fonts/**/*").addResourceLocations("resources/fonts/");
//		registry.addResourceHandler("/js/**/*").addResourceLocations("resources/js/");
//		registry.addResourceHandler("/lib/**/*").addResourceLocations("resources/lib/");
//	}
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}