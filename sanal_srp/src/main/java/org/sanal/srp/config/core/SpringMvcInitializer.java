package org.sanal.srp.config.core;

import org.sanal.srp.config.AppConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sanal567 Date 14-10-18 3:28 PM
 */
@Order(1) // Filters declared at the Dispatcher initializer should be registered first
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/*
	 * public SpringMvcInitializer() { super(); }
	 * 
	 * @Override protected Class<?>[] getServletConfigClasses() { return new
	 * Class<?>[] { SpringWebConfig.class }; }
	 * 
	 * @Override protected Class<?>[] getRootConfigClasses() { return new Class<?>[]
	 * { SpringSecurityConfig.class }; }
	 * 
	 * public static final String CHARACTER_ENCODING = "UTF-8";
	 * 
	 * @Override protected Filter[] getServletFilters() { final
	 * CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	 * encodingFilter.setEncoding(CHARACTER_ENCODING);
	 * encodingFilter.setForceEncoding(true); return new Filter[] { encodingFilter
	 * }; }
	 */
}