package com.prokarma.pkmst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.prokarma.pkmst.interceptor.AuditInterceptor;
import com.prokarma.pkmst.interceptor.BodyInterceptor;
//import com.prokarma.pkmst.interceptor.CorrelationInterceptor;
import com.prokarma.pkmst.interceptor.RateLimitInterceptor;
import com.prokarma.pkmst.interceptor.TraceabilityInterceptor;
/**
 * Registers the interceptors which are configurable via yaml
 * @author pkmst
 *
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	

	/**
	 * enabling cors support at global level which can be applied at various
	 * level also as below registry.addMapping("/api/**")
	 * .allowedOrigins("http://domain2.com") .allowedMethods("PUT", "DELETE")
	 * .allowedHeaders("header1", "header2", "header3")
	 * .exposedHeaders("header1", "header2")
	 * .allowCredentials(false).maxAge(3600);
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}