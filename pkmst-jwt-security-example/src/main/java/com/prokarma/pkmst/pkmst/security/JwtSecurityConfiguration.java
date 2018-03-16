/**
 * 
 */
package com.prokarma.pkmst.pkmst.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prokarma.pkmst.pkmst.config.Constants;

/**
 * @author prokarma
 *
 */
@Configuration
@Order(1)
@EnableWebSecurity
public class JwtSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// a method where we can define which resources are public and which are secured
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()

				.antMatchers(HttpMethod.POST, Constants.SIGN_UP_URL).permitAll()

				.anyRequest().authenticated()

				.and()

				.addFilter(new JwtAuthenticationFilter(authenticationManager()))

				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	// a method where we defined a custom implementation of UserDetailsService to
	// load user-specific data in the security framework.
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {// Create a default account
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	}

	/**
	 * 
	 */
	public JwtSecurityConfiguration() {
	}

	/**
	 * @param disableDefaults
	 */
	public JwtSecurityConfiguration(boolean disableDefaults) {
		super(disableDefaults);
	}

}
