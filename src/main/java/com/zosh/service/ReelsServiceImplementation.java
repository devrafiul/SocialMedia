package com.zosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.models.Reels;
import com.zosh.models.User;
import com.zosh.repository.ReelsRepository;


@Service
public class ReelsServiceImplementation implements ReelsService {

	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public Reels createReel(Reels reel, User user) {
		// TODO Auto-generated method stub
		
		Reels createReel = new Reels();
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVedio(reel.getVedio());
		
		
		Reels savedReels = reelsRepository.save(createReel);
		
		return savedReels;
	}

	@Override
	public List<Reels> findAllReels() {
		// TODO Auto-generated method stub
		
		return reelsRepository.findAll();
		
		//return null;
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		 userService.findUserById(userId);
		
		return reelsRepository.findByUserId(userId);
		
		//return null;
	}

}
