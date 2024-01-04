package com.zosh.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.UserException;
import com.zosh.models.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	//create user
	
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		/*User newUser = new User();
		
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		
		User savedUser = userRepository.save(newUser);*/
		
		User savedUser = userService.registerUser(user);
		
		return savedUser;
	}
	

	//all users get
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users;
		
		
		
		
		
		/*List<User>users=new ArrayList<>();
		
		User user1= new User(1,"code","zosh","codewithzosh@gmailcom","123456");
		User user2= new User(2,"codewith","Durgesh","codewithdurgesh@gmailcom","123456");
		
		users.add(user1);
		users.add(user2);
		
		return users;*/
	}
	
	//single users get
	
	@GetMapping("/api/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer id) throws UserException{
		
		/*
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new Exception("user not exist with userid "+id);*/
		
		
		
		User user = userService.findUserById(id);
		return user;
		
		
		
		/*User user1= new User(1,"code","zosh","codewithzosh@gmailcom","123456");
		
		user1.setId(id);
		
		
		
		return user1;*/
	}
	
	
	
	
	

	
	//update user
	
	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization")String jwt,@RequestBody User user) throws UserException {
		
		/*
		Optional<User> user1 = userRepository.findById(userId);
		
		if(user1.isEmpty()) {
			throw new Exception("User not exit with id "+userId);
		}
		
		User oldUser = user1.get();
		
		
		if(user.getFirstName()!=null) {
			oldUser.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		
		if(user.getPassword()!=null) {
			oldUser.setPassword(user.getPassword());
		}
		
		
		User updatedUser = userRepository.save(oldUser);
		
		return updatedUser;*/
		
		
		User reqUser = userService.findUserByJwt(jwt);
		User updatedUser = userService.updateUser(user, reqUser.getId());
		
		return updatedUser;
		
		
		
		
		/*	User user1=new User(1,"code","zosh","codewithzosh@gmailcom","123456");
			
			if(user.getId()!=null) {
				user1.setId(user.getId());
			}
			
			if(user.getFirstName()!=null) {
				user1.setFirstName(user.getFirstName());
			}
			
			if(user.getLastName()!=null) {
				user1.setLastName(user.getLastName());
			}
			
			if(user.getEmail()!=null) {
				user1.setEmail(user.getEmail());
			}
			
			if(user.getPassword()!=null) {
				user1.setPassword(user.getPassword());
			}
			
			return user1;*/
		
		
		
		
	}
	
	
	
	
	
	
	//delete user
	
	@DeleteMapping("/api/users/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		
		return "user deleted successfully with id" + userId;
	}
	
	
	
	
	//follow user
	
	@PutMapping("/api/users/follow/{userId2}")
	public User followUserHandler(@RequestHeader("Authorization")String jwt,@PathVariable Integer userId2) throws UserException {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		User user = userService.followUser(reqUser.getId(), userId2);
		
		return user;
	}
	
	
	
	@GetMapping("/api/users/search")
	public List<User>searchUser(@RequestParam("query") String query){
		
		List<User> users = userService.searchUser(query);
		
		return users;
		
	}
	
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
		
		
		//System.out.println("jwt-----"+jwt);
		
		User  user= userService.findUserByJwt(jwt);
		user.setPassword(null);
		
		return user;
	}
}
