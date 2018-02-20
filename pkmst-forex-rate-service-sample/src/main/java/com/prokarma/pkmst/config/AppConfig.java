package com.prokarma.pkmst.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
	
    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2).
        		addScript("drop-db.sql").addScript("create-db.sql").addScript("insert-data.sql").build();
        return embeddedDatabase;
    }
}