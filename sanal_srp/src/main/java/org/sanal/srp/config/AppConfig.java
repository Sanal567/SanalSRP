package org.sanal.srp.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * This configuration class configures the persistence layer of application and
 * enables annotation driven transaction management.
 *
 * This configuration is put to a single class because this way we can write
 * integration tests for our persistence layer by using the configuration used
 * by our example application. In other words, we can ensure that the
 * persistence layer of our application works as expected.
 *
 * @author sanal567 Date 14-10-18 10:58 PM
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories(basePackages = { "org.sanal.srp.repository" })
@ComponentScan({ "org.sanal.srp.*" })
@Import({ SecurityConfig.class })
public class AppConfig implements WebMvcConfigurer/* extends WebMvcConfigurerAdapter */ {

	@Autowired
	private Environment environment;

	/**
	 * Creates and configures the HikariCP datasource bean.
	 * 
	 * @return {@link DataSource}
	 */

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDataSourceClassName(environment.getProperty("dataSourceClassName"));
		dataSourceConfig.setJdbcUrl(environment.getProperty("hibernate.connection.url"));
		dataSourceConfig.setUsername(environment.getProperty("hibernate.connection.username"));
		dataSourceConfig.setPassword(environment.getProperty("hibernate.connection.password"));
		dataSourceConfig.setPoolName("aaaa");
		// dataSourceConfig.setConnectionTestQuery("SELECT 1"); //
		// dataSourceConfig.setMaximumPoolSize(100); //
		// dataSourceConfig.addDataSourceProperty("cachePrepStmts", true); //
		// dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", 250); //
		// dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048); //
		// dataSourceConfig.addDataSourceProperty("useServerPrepStmts", true);
		return new HikariDataSource(dataSourceConfig);
	}

	/**
	 * Creates the bean that creates the JPA entity manager factory.
	 * 
	 * @param dataSource The datasource that provides the database connections.
	 * @return {@link LocalContainerEntityManagerFactoryBean}
	 */

	// @Autowired
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		// vendorAdapter.setShowSql(false);
		// vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		// vendorAdapter.setDatabase(Database.MYSQL);

		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("org.sanal.srp.entities");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		// Specifies the action that is invoked to the database when the Hibernate
		// SessionFactory is created or closed.
		// jpaProperties.put("hibernate.hbm2ddl.auto",
		// environment.getProperty("hibernate.hbm2ddl.auto"));
		// Configures the naming strategy that is used when Hibernate creates
		// new database objects and schema elements
		jpaProperties.put("hibernate.implicit_naming_strategy",
				environment.getProperty("hibernate.implicit_naming_strategy"));
		// If the value of this property is true, Hibernate will use prettyprint
		// when it writes SQL to the console.
		jpaProperties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		// jpaProperties.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults",
		// env.getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
		jpaProperties.put("hibernate.jdbc.lob.non_contextual_creation",
				environment.getProperty("hibernate.jdbc.lob.non_contextual_creation"));
		jpaProperties.put("hibernate.enable_lazy_load_no_trans",
				environment.getProperty("hibernate.enable_lazy_load_no_trans"));
//	jpaProperties.setProperty("hibernate.default_schema", environment.getProperty("hibernate.default_schema"));
		jpaProperties.setProperty("hibernate.cache.use_second_level_cache",
				environment.getProperty("hibernate.cache.use_second_level_cache"));
		jpaProperties.setProperty("hibernate.cache.region.factory_class",
				environment.getProperty("hibernate.cache.region.factory_class"));
		jpaProperties.setProperty("hibernate.javax.cache.provider",
				environment.getProperty("hibernate.javax.cache.provider"));

		jpaProperties.setProperty("hibernate.cache.use_query_cache",
				environment.getProperty("hibernate.cache.use_query_cache"));
		jpaProperties.setProperty("hibernate.generate_statistics",
				environment.getProperty("hibernate.generate_statistics"));

		jpaProperties.setProperty("hibernate.connection.provider_class",
				environment.getProperty("hibernate.connection.provider_class"));

		jpaProperties.setProperty("hibernate.hikari.dataSourceClassName",
				environment.getProperty("dataSourceClassName"));
		jpaProperties.setProperty("hibernate.hikari.username",
				environment.getProperty("hibernate.connection.username"));
		jpaProperties.setProperty("hibernate.hikari.password",
				environment.getProperty("hibernate.connection.password"));
		// jpaProperties.setProperty("hibernate.hikari.jdbcUrl",
		// environment.getProperty("hibernate.connection.url"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		// entityManagerFactoryBean.afterPropertiesSet();

		return entityManagerFactoryBean;
	}

	/**
	 * Creates the transaction manager bean that integrates the used JPA provider
	 * with the Spring transaction mechanism.
	 * 
	 * @param entityManagerFactory The used JPA entity manager factory.
	 * @return {@link JpaTransactionManager}
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		// transactionManager.setJpaDialect(new HibernateJpaDialect());
		return transactionManager;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/global/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/images/**/*").addResourceLocations("/resources/images/");
//		registry.addResourceHandler("/fonts/**/*").addResourceLocations("/resources/fonts/");
		registry.addResourceHandler("/js/**/*").addResourceLocations("/resources/js/");
//		registry.addResourceHandler("/lib/**/*").addResourceLocations("/resources/lib/");
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
//		registry.addResourceHandler("/open/**/*").addResourceLocations("/WEB-INF/views/pages/public/");
//		registry.addResourceHandler("/secured/**/*").addResourceLocations("/WEB-INF/views/pages/secured/");
//		registry.addResourceHandler("/admin/**/*").addResourceLocations("/WEB-INF/views/pages/admin/");
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}