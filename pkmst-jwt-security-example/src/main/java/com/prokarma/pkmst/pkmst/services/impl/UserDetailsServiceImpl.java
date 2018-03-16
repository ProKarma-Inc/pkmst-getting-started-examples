/**
 * 
 */
package com.prokarma.pkmst.pkmst.services.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prokarma.pkmst.pkmst.dao.UserRepository;
import com.prokarma.pkmst.pkmst.dto.User;

/**
 * @author prokarma
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository applicationUserRepository;

	public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	/**
	 * 
	 */
	public UserDetailsServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User applicationUser = applicationUserRepository.findByUsername(username);

		if (applicationUser == null) {

			throw new UsernameNotFoundException(username);

		}

		return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(),
				applicationUser.getPassword(), Collections.emptyList());
	}

}
