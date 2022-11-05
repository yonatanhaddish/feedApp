package com.bptn.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.model.Post;
import com.bptn.repository.FeedRepository;

@Service
public class FeedService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedRepository feedRepository;
	
	@Autowired
	private UserService userService;
	
	
	public List<Post> getPostsByUsername(String username) throws InvalidUserNameException {
		
		LOGGER.info("retreiving Posts from DB by username");
		
		userService.validateUserId(username);
		
		List<Post> posts = feedRepository.findByUsername(username);
		
		posts = removeEmptyPosts(posts);
		
		LOGGER.debug("Feeds = {}", posts);
		
		return posts;
	}
	
	public Post getPostsByPostId(String postID) throws InvalidPostException {
		
		LOGGER.info("retreving Posts from DB by PostID");
		
		Post post = feedRepository.findByPostID(postID);
		
		if (post == null) {
			
			throw new InvalidPostException("PostID does not exists");
		}
		
		LOGGER.debug("Feed = {}", post);
		
		return post;
	}
	
	
	public List<Post> getPostsByPostType(String postType) throws InvalidPostException {
		
		LOGGER.info("retreving Posts from DB by PostType");
		
		List<Post> posts = feedRepository.findByPostType(postType);
		
		posts = removeEmptyPosts(posts);
		
		if (posts == null) {
			throw new InvalidPostException("PostType does not exist");
		}
		
		LOGGER.debug("Feed = {}", posts);
		
		return posts;
	}


	private List<Post> removeEmptyPosts(List<Post> posts) {
		
		List<Post> resultPosts = new LinkedList<>();
		
		for (Post post : posts) {
			
			if (post.getPost() != null && !post.getPost().isEmpty()) {
				resultPosts.add(post);
			}
		}
		return resultPosts;
	}

}

