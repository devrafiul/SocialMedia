package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.config.JwtProvider;
import com.zosh.models.User;
import com.zosh.repository.UserRepository;
import com.zosh.request.LoginRequest;
import com.zosh.response.AuthRespone;
import com.zosh.service.CustomUserDetailsService;
import com.zosh.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	private CustomUserDetailsService customUserDetails;
	
	@PostMapping("/signup")
	public AuthRespone createUser(@RequestBody User user) throws Exception {
		
		User isExist = userRepository.findByEmail(user.getEmail());
		
		if(isExist!=null) {
			throw new Exception("email already used with another account");
		}
		
		
		User newUser = new User();
		
		
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setGender(user.getGender());
		
		User savedUser= userRepository.save(newUser);
		
		
		Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser,savedUser.getPassword());
		
		String token=JwtProvider.generateToken(authentication);
		
		AuthRespone res = new AuthRespone(token,"Register Success");
		
		return res;
	}
	
	@PostMapping("/signin")
	public AuthRespone singin(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication =authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthRespone res = new AuthRespone(token,"Login Succeess");
		
		return res;
	}


	
	private Authentication authenticate(String email, String password) {
		
	    UserDetails userDetails = customUserDetails.loadUserByUsername(email);
		
	    if(userDetails==null) {
	    	throw new BadCredentialsException("invalid username");
	    }
	    
	    if(!passwordEncoder.matches(password, userDetails.getPassword())) {
	    	throw new BadCredentialsException("password not matched");
	    }
	    
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
}
