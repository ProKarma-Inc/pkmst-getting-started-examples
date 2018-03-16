package com.prokarma.pkmst.pkmst.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.prokarma.pkmst.pkmst.config.Constants;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "my_rest_api";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers(HttpMethod.POST, Constants.SIGN_UP_URL).permitAll()
				.anyRequest().authenticated();

		// http.anonymous().disable().requestMatchers().antMatchers(HttpMethod.GET,
		// "/products").and()
		// .authorizeRequests().anyRequest().authenticated().antMatchers(HttpMethod.GET,
		// "/products")
		// .access("hasRole('ADMIN')").and().exceptionHandling()
		// .accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
