/**
 * 
 */
package com.prokarma.pkmst.pkmst.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.pkmst.config.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author prokarma
 *
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	// parse the user's credentials and issue them to the AuthenticationManager
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,

			HttpServletResponse res) throws AuthenticationException {

		try {

			com.prokarma.pkmst.pkmst.dto.User creds = new ObjectMapper()

					.readValue(req.getInputStream(), com.prokarma.pkmst.pkmst.dto.User.class);

			return authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(

							creds.getUsername(),

							creds.getPassword(),

							new ArrayList<>())

			);

		} catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

	// method called when a user successfully logs in. We use this method to
	// generate a JWT for this user.
	@Override
	protected void successfulAuthentication(HttpServletRequest req,

			HttpServletResponse res,

			FilterChain chain,

			Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder()

				.setSubject(((User) auth.getPrincipal()).getUsername())

				.setExpiration(new Date(System.currentTimeMillis() + Constants.EXPIRATION_TIME))

				.signWith(SignatureAlgorithm.HS512, Constants.SECRET)

				.compact();
		System.out.println("JWT Token:" + token);
		res.addHeader(Constants.HEADER_STRING, Constants.TOKEN_PREFIX + token);

	}
}
