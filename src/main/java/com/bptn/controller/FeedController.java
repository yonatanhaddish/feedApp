package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/")
	public ResponseEntity<String> ping() {
		
		logger.debug("Exceuting ping()");
		
		return new ResponseEntity<String>("feed App UP and running and running", HttpStatus.OK);
		
	}

}
