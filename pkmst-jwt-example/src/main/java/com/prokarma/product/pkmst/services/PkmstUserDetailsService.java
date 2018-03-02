package com.prokarma.product.pkmst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by nydiarra on 06/05/17.
 */
@Component
public class PkmstUserDetailsService implements UserDetailsService {
    

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	UserDetails userDetails = null;
    	if(s!=null && s.equals("anshu")) {
    		List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ADMIN"));
           
         userDetails = new org.springframework.security.core.userdetails.
                User("anshu", "abc123", authorities);
    	}
    	
    	if(s!=null && s.equals("bob")) {
    		List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("USER"));
           
         userDetails = new org.springframework.security.core.userdetails.
                User("bob", "abc123", authorities);
    	}

        return userDetails;
    }
}
