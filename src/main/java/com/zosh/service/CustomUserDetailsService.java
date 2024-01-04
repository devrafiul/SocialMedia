package com.zosh.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.zosh.models.User;
import com.zosh.repository.UserRepository;

@Service
public class CustomUserDetailsService<GrantedAuthority> implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByEmail(username);
		
		 if(user==null) {
			 throw new UsernameNotFoundException("user not found with email "+ username);
		 }
		 
		List<org.springframework.security.core.GrantedAuthority> authorities =new ArrayList<>();
		
		 
		 return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), authorities);
	}

}
