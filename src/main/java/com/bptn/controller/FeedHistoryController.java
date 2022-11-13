package com.bptn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bptn.exceptions.InvalidHistoryException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.model.History;
import com.bptn.service.FeedHistoryService;

@Controller
public class FeedHistoryController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedHistoryService feedHistoryService;
	
	@GetMapping(value = "/history/username/{usernameKey}")
	public ResponseEntity<Object> getPostsByUsername(@PathVariable("usernameKey") String usernameKey) {
		LOGGER.debug("Executing getPostsByUsername API");
		List<History> feeds;
		
		try {
			feeds = feedHistoryService.getPostsByUsername(usernameKey);
		}
		catch (InvalidUserNameException e) {
			LOGGER.error("Unable to find History by usernameKey, cause={}", e.getMessage());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return new ResponseEntity<>(feeds, HttpStatus.OK);	
	}
	
	@GetMapping(value = "history/postid/{postId}")
	public ResponseEntity<Object> getPostsByPostId(@PathVariable("postId") String postId) {
		LOGGER.debug("Executing getPostsByPostId API");
		History feeds;
		
		try {
			feeds = feedHistoryService.getPostsByPostId(postId);
		}
		catch(InvalidHistoryException e) {
			LOGGER.error("Unable to find History by postId, cause={}", e.getMessage());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return new ResponseEntity<>(feeds, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/history/posttype/{postType}")
	public ResponseEntity<Object> getPostByPostType(@PathVariable("postType") String postType) {
		LOGGER.debug("Executing getPostByPostType API");
		List<History> feeds;
		
		try {
			feeds = feedHistoryService.getPostsByPostType(postType);
		}
		catch(InvalidHistoryException e) {
			LOGGER.error("Unable to find History by postType, cause={}", e.getMessage());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return new ResponseEntity<>(feeds, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/history/delete/posttype/{postType}")
	public ResponseEntity<Object> deletePostsByPostType(@PathVariable("postType") String postType) {
		LOGGER.debug("Executing deletePostsByPostType API");
		
		try {
			feedHistoryService.deleteHistoryByPostType(postType);
		}
		catch(InvalidHistoryException e) {
			LOGGER.error("Unable to find History by postType, cause={}", e.getMessage());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().body("history deleted successfully");
	}

}
