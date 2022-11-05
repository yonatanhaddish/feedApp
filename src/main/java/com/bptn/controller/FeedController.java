package com.bptn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.model.Post;
import com.bptn.service.FeedService;

@Controller
public class FeedController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedService feedService;
	
	@GetMapping("/")
	public ResponseEntity<String> ping() {
		
		logger.debug("Exceuting ping()");
		
		return new ResponseEntity<String>("feed App UP and running and running", HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value = "/posts/username/{username}")
	public ResponseEntity<Object> getPostsByUsername(@PathVariable("username") String username) {
		
		logger.info("Executing getPostByUsername API");
		
		List<Post> feeds;
		
		try {
			feeds = feedService.getPostsByUsername(username);
		}
		catch (InvalidUserNameException e) {
			
			logger.error("Unable to find post by username, cause = {}", e.getCause());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return new ResponseEntity<>(feeds, HttpStatus.OK);
}
	
	
	@GetMapping(value = "/posts/postid/{postID}")
	public ResponseEntity<Object> getPostsByPostId(@PathVariable("postID") String postID) {
		
		logger.info("Executing getPostByPostID API");
		
		Post feeds;
		
		try {
			feeds = feedService.getPostsByPostId(postID);
		}
		catch (InvalidPostException e) {
			
			logger.error("Unable to find post by postID, cause = {}", e.getCause());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return new ResponseEntity<>(feeds, HttpStatus.OK);
}
	
	
	@GetMapping(value = "/posts/posttype/{postType}")
	public ResponseEntity<Object> getPostsByPostType(@PathVariable("postType") String postType) {
		
		logger.info("Executing getPostByPostType API");
		
		List <Post> feeds;
		
		try {
			feeds = feedService.getPostsByPostType(postType);
		}
		catch (InvalidPostException e) {
			
			logger.error("Unable to find post by postID, cause = {}", e.getCause());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return new ResponseEntity<>(feeds, HttpStatus.OK);
}
	
	

}
