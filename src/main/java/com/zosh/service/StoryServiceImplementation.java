package com.zosh.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.models.Story;
import com.zosh.models.User;
import com.zosh.repository.StoryRepository;
import com.zosh.repository.UserRepository;


@Service
public class StoryServiceImplementation implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public Story createStory(Story story, User user) {
		// TODO Auto-generated method stub
		
		Story createdStory = new Story();
		
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());
		
		Story savedStory = storyRepository.save(createdStory);
		
		return savedStory;
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		
		User findUserById = userService.findUserById(userId);
		
		return storyRepository.findByUserId(userId);
		
		
		//return null;
	}
	
	
	

}
