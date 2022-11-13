package com.bptn.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidHistoryException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.model.History;
import com.bptn.repository.FeedHistoryRepository;

@Service
public class FeedHistoryService {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedHistoryRepository feedHistoryRepository;
	
	public List<History> getPostsByUsername(String usernameKey)throws InvalidUserNameException {
		
		LOGGER.info("retrieving History from DB by username");
		userService.validateUserId(usernameKey);
		List<History> history = feedHistoryRepository.findByUsernameKey(usernameKey);
		history = removeEmptyHistory(history);
		LOGGER.debug("Feeds History={}", history);
		
		return history;
	}
	
	public History getPostsByPostId(String postId) throws InvalidHistoryException {
		
		LOGGER.info("retrievig History from DB by postId");
		History history = feedHistoryRepository.findByPostID(postId);
		if (history == null) {
			throw new InvalidHistoryException("history data does't exist");
		}
		LOGGER.debug("Feed history={}", history);

		return history;	
	}
	
	public List<History> getPostsByPostType(String postType) throws InvalidHistoryException {
		
		LOGGER.info("retrieving History from DB by postType");
		List<History> history = feedHistoryRepository.findByPostType(postType);
		if (history == null) {
			throw new InvalidHistoryException("history data does't exist");
		}
		LOGGER.debug("Feed history={}", history);
		
		return history;
	}
	
	public void deleteHistoryByPostType(String postType) throws InvalidHistoryException {
		
		try {
			feedHistoryRepository.deleteByPostType(postType);
		}
		catch(Exception e) {
			throw new InvalidHistoryException("History does't exist");
		}
	}

	private List<History> removeEmptyHistory(List<History> history) {
		
		List<History> resultHistory = new LinkedList<>();
		for (History historyData : history) {
			
			if (historyData.getPostID() != null && !historyData.getPostID().isEmpty()) {
				resultHistory.add(historyData);
			}
		}
		return resultHistory;
	}
	
}