/**
 * 
 */
package com.prokarma.pkmst.pkmst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.pkmst.pkmst.dao.UserRepository;
import com.prokarma.pkmst.pkmst.dto.User;

/**
 * @author prokarma
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository applicationUserRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private UserDetailsService userDetailsService;

	public UserController(UserRepository applicationUserRepository,

			BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.applicationUserRepository = applicationUserRepository;

		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	/**
	 * 
	 */
	public UserController() {
	}

	@RequestMapping(value = ("/sign-up"), method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void signUp(@RequestBody User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		applicationUserRepository.save(user);

	}

	@RequestMapping(value = ("/login"), method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestBody User user) {

		userDetailsService.loadUserByUsername(user.getUsername());

	}

}
