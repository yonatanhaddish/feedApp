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

import com.bptn.exceptions.InvalidImageMetaDataException;
import com.bptn.model.ImageMetaData;
import com.bptn.service.FeedMediaService;

@Controller
public class FeedMediaController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedMediaService feedMediaService;
	
	@GetMapping(value = "/image/metadata/{postKey}")
	public ResponseEntity<Object> getImageMediaByPostKey(@PathVariable("postKey") String postkeyCred) {
		
		LOGGER.debug("Executing getImageMediaPostKey API ");
		
		List<ImageMetaData> imageMetaDataList;
		
		try {
			imageMetaDataList = feedMediaService.getImageMediaByPostKey(postkeyCred);
		}
		catch (InvalidImageMetaDataException e) {
			
			LOGGER.error("Unable to find image Metadata by postkey, cause = {}", e.getMessage());
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return new ResponseEntity<>(imageMetaDataList, HttpStatus.OK);
		
		
	}

}
