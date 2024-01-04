package com.zosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.config.JwtProvider;
import com.zosh.exceptions.UserException;
import com.zosh.models.User;
import com.zosh.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		
		User newUser=new User();
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setGender(user.getGender());
		
		User savedUser = userRepository.save(newUser);
		
		
		return savedUser;
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User not exist userid "+ userId);
		
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {
		// TODO Auto-generated method stub
		
		User reqUser=findUserById(reqUserId);
		
		User user2=findUserById(userId2);
		
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(user2.getId());
		
		userRepository.save(reqUser);
		userRepository.save(user2);
		
		return reqUser;
	}

	@Override
	public User updateUser(User user,Integer userId) throws UserException {
		// TODO Auto-generated method stub
		
		Optional<User> user1 = userRepository.findById(userId);
		
		if(user1.isEmpty()) {
			throw new UserException("User not exit with id"+ userId);
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
		
		if(user.getGender()!=null) {
			oldUser.setGender(user.getGender());
		}
		
		User updateUser = userRepository.save(oldUser);
		
		return updateUser;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return userRepository.searchUser(query);
	}

	@Override
	public User findUserByJwt(String jwt) {
		// TODO Auto-generated method stub
		
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		
		User user = userRepository.findByEmail(email);
		return user;
	}

}
