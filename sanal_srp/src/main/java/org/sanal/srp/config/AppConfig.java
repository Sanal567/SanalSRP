package org.sanal.srp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

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

//@EnableCaching
@EnableSpringDataWebSupport
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories(basePackages = { "org.sanal.srp.repository" })
@ComponentScan({ "org.sanal.srp.*" })
@Import({ SpringSecurityConfig.class })
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware/* extends WebMvcConfigurerAdapter */ {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

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

		// HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// vendorAdapter.setGenerateDdl(true);
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
		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
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
		jpaProperties.setProperty("javax.persistence.sharedCache.mode",
				environment.getProperty("javax.persistence.sharedCache.mode"));

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

	/* **************************************************************** */
	/* THYMELEAF-SPECIFIC ARTIFACTS */
	/* TemplateResolver <- TemplateEngine <- ViewResolver */
	/* **************************************************************** */

	public SpringResourceTemplateResolver templateResolver() {
		// SpringResourceTemplateResolver automatically integrates with Spring's own
		// resource resolution infrastructure, which is highly recommended.
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		// HTML is the default value, added here for the sake of clarity.
		templateResolver.setTemplateMode(TemplateMode.HTML);
		// Template cache is true by default. Set to false if you want
		// templates to be automatically updated when modified.
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		// SpringTemplateEngine automatically applies SpringStandardDialect and
		// enables Spring's own MessageSource message resolution mechanisms.
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		// Enabling the SpringEL compiler with Spring 4.2.4 or newer can
		// speed up execution in most scenarios, but might be incompatible
		// with specific cases when expressions in one template are reused
		// across different data types, so this flag is "false" by default
		// for safer backwards compatibility.
		templateEngine.setEnableSpringELCompiler(true); // Compiled SpringEL should speed up executions
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		// NOTE 'order' and 'viewNames' are optional
		// viewResolver.setOrder(1);
		// viewResolver.setViewNames(new String[] {".html", ".xhtml"});
		return viewResolver;
	}

//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}

	/* ******************************************************************* */
	/* Defines callback methods to customize the Java-based configuration */
	/* for Spring MVC enabled via {@code @EnableWebMvc} */
	/* ******************************************************************* */

	/**
	 * Dispatcher configuration for serving static resources
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**/*").addResourceLocations("/resources/images/");
		registry.addResourceHandler("/js/**/*").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
	}

	/**
	 * Message externalization/internationalization
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/*
	 * @Bean public CacheManager cacheManager() { SimpleCacheManager cacheManager =
	 * new SimpleCacheManager(); cacheManager.setCaches(Arrays.asList(new
	 * ConcurrentMapCache("byFirstNameAndLastName"))); return cacheManager; }
	 * 
	 * @Bean(name = "cacheManager") public EhCacheCacheManager ehCacheCacheManager()
	 * { return new EhCacheCacheManager(ehCache()); }
	 * 
	 * @Bean public CacheManager ehCache() { CacheManager cacheManager =
	 * CacheManager.create(); Cache sampleEntityCache = new Cache(new
	 * CacheConfiguration("com.abc.examples.entity.SampleEntity", 500)
	 * .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU).eternal(false).
	 * timeToLiveSeconds(60 * 60 * 24) .timeToIdleSeconds(60 * 60 * 24)
	 * .persistence(new
	 * PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.NONE)))
	 * ; cacheManager.addCache(sampleEntityCache); return cacheManager; }
	 */
}