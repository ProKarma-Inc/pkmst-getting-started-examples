package com.prokarma.pkmst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prokarma.pkmst.model.User;
import com.prokarma.pkmst.model.UserRepository;


/**
 * This class is used by spring controller to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
    	return null;
    }
    public UserDetails loadUserByUsernamePassword(String username,String password) throws UsernameNotFoundException
    {   
    	User curruser = repository.findByUsername(username);
    	System.out.println("############################################################");
    	System.out.println("user name : " + username);
    	
        UserDetails user = new org.springframework.security.core.userdetails.User(username, password, true, 
        		true, true, true, AuthorityUtils.createAuthorityList(curruser.getRole()));
        
        System.out.println("ROLE: " + curruser.getRole());
        System.out.println("user obj : " + user);
        return user;
    }
}