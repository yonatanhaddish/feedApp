package com.bptn.service;

import com.bptn.model.Post;
import com.bptn.repository.FeedPostRepository;
import com.bptn.request.FeedPostRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Random;

@Service
public class FeedPostService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.base.url}")
    private String apiBaseUrl;
    
    private static final String POST_TYPE = "news";

    @Autowired
    private FeedPostRepository feedPostRepository;

    public Post getPostFromNewsAndSavePost(FeedPostRequest feedPostRequest) {
        String url = buildApiUrl(feedPostRequest);
        LOGGER.debug("News Feed URL = {}", url);
        String feedResult = getFeedFromNewsAPI(url);
        return storeFeed(feedResult, feedPostRequest);
    }

    private Post storeFeed(String feedResult, FeedPostRequest feedPostRequest) {
        Post feed = new Post();
        feed.setPost(feedResult);
        feed.setPostType(POST_TYPE);
        feed.setUsernameKey(feedPostRequest.getUserName());
        LOGGER.debug("Feed to be stored : {}", feed);
        return feedPostRepository.save(feed);
    }

    private String generatePostId(FeedPostRequest feedPostRequest) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder postIdBuilder = new StringBuilder();
        postIdBuilder.append(random.nextInt());
        postIdBuilder.append(Objects.hashCode(feedPostRequest.getUserName() + " " + feedPostRequest.getQueryKeyword()));
        String postId = postIdBuilder.toString();
        if (postId.startsWith("-")) {
            return postId.substring(1);
        }
        return postId;
    }

    private String getFeedFromNewsAPI(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(result);
        String postDescription =
                jsonElement.getAsJsonObject().get("articles").getAsJsonArray().get(0).getAsJsonObject().get("description").toString();
        return postDescription;
    }

    private String buildApiUrl(FeedPostRequest feedPostRequest) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(apiBaseUrl);
        urlBuilder.append("?q=").append(feedPostRequest.getQueryKeyword());
        if (feedPostRequest.getFromDate() != null && !feedPostRequest.getFromDate().isEmpty()) {
            urlBuilder.append("&from=").append(feedPostRequest.getFromDate());
        }
        if (feedPostRequest.getToDate() != null && !feedPostRequest.getToDate().isEmpty()) {
            urlBuilder.append("&to=").append(feedPostRequest.getToDate());
        }
        urlBuilder.append("&apiKey=").append(apiKey);
        return urlBuilder.toString();
    }
}

//package com.bptn.service;
//
//import java.util.Objects;
//import java.util.Random;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.bptn.model.Post;
//import com.bptn.repository.FeedPostRepository;
//import com.bptn.request.FeedPostRequest;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//
//@Service
//public class FeedPostService {
//	
//	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//	
//	@Value("${api.key}")
//	private String apiKey;
//	
//	@Value("${api.base.url}")
//	private String apiBaseUrl;
//	
//	@Autowired
//	private FeedPostRepository feedPostRepository;
//	private static final String POST_TYPE = "news";
//	
////	this method getPostFromNewAndSavePost.
////  step 1: build the third party API url using the feedPostRequest object parameters entered by the user.
////	step 2: print logger information once the url is built
////	step 3: create a feedResult by calling the getFeedFromNewsAPI which gets the first post description.
////	step 4: store the feedResult into my Post table column.
//	
//	public Post getPostFromNewsAndSavePost(FeedPostRequest feedPostRequest) {
//		
//		String url = buildApiUrl(feedPostRequest);
//		LOGGER.debug("News Feed URL = {}", url);
//		String feedResult = getFeedFromNewsAPI(url);
//		return storeFeed(feedResult, feedPostRequest);
//	}
//	
////	store feed method is to create the feed object (PostType, Post, username, PostId)
//	private Post storeFeed(String feedResult, FeedPostRequest feedPostRequest) {
//		
//		Post feed = new Post();
//		
//		feed.setPost(feedResult);
////		feed.setPostType(feedPostRequest.getQueryKeyword());
//		feed.setPostType(POST_TYPE);
//		feed.setUserNameKey(feedPostRequest.getUserName());
//		feed.setPostID(generatePostId(feedPostRequest));
//		
//		LOGGER.debug("Feed to be tored: {}", feed);
//		
//		return feedPostRepository.save(feed);
//			
//	}
//	
//	private String generatePostId(FeedPostRequest feedPostRequest) {
//		
//		Random random = new Random(System.currentTimeMillis());
//		StringBuilder postIdBuilder = new StringBuilder();
//		
//		postIdBuilder.append(random.nextInt());
//		
//		postIdBuilder.append(Objects.hashCode(feedPostRequest.getUserName() + " " + feedPostRequest.getQueryKeyword()));
//		
//		String postId = postIdBuilder.toString();
//		
//		
//		if (postId.startsWith("-") ) {
//			return postId.substring(1);
//		}
//		return postId;
//	}
//	
//	
//	private String getFeedFromNewsAPI(String url) {
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		String result = restTemplate.getForObject(url,  String.class);
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		
//		JsonElement jsonElement = JsonParser.parseString(result);
//		
////		String prettyjsonString = gson.toJson(jsonElement);
//		String postDescription = gson.toJson(jsonElement.getAsJsonObject().get("articles").getAsJsonArray().get(0).getAsJsonObject().get("description"));
//		
//		return postDescription;
//	}
//	
//	
//	private String buildApiUrl(FeedPostRequest feedPostRequest) {
//		
//		StringBuilder urlBuilder = new StringBuilder();
//		
//		urlBuilder.append(apiBaseUrl);
//		
//		urlBuilder.append("?q=").append(feedPostRequest.getQueryKeyword());
//		
//		if (feedPostRequest.getFromDate() != null && !feedPostRequest.getFromDate().isEmpty()) {
//			urlBuilder.append("&from=").append(feedPostRequest.getFromDate());
//		}
//		
//		if (feedPostRequest.getToDate() != null && !feedPostRequest.getToDate().isEmpty()) {
//			urlBuilder.append("&to=").append(feedPostRequest.getToDate());
//		}
//		
//		urlBuilder.append("&apiKey=").append(apiKey);
//		
//		
//		return urlBuilder.toString();
//	}
//	
//}
//
