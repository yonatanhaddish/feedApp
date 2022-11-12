package com.bptn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.repository.FeedHistoryRepository;

@Service
public class FeedHistoryService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedHistoryRepository feedHistoryRepository;
	
	@Autowired
	private UserService userService;
	
	public List<History> getPostByUsername(String username) throws InvalidUserNameException {
		
		LOGGER.info("retreiving History from DB by username");
		
		List<History> history = feedHisotyRepository.findByUsername(username);
		
		return null;
	}

}
