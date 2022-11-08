package com.bptn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.model.Post;

@Repository
public interface FeedRepository extends JpaRepository<Post, String> {
	
	List<Post> findByUsername(String username);
	
	Post findByPostID(String postID);
	
	List<Post> findByPostType(String postType);
	
}
