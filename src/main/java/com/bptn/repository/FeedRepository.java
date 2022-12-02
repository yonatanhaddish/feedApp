package com.bptn.repository;

import com.bptn.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Post, String> {
	
    List<Post> findAllByUsernameKey(String username);

    Post findById(long postID);

    Post findByPostType(String postType);

}

//package com.bptn.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.bptn.model.Post;
//
//@Repository
//public interface FeedRepository extends JpaRepository<Post, String> {
//	
//	List<Post> findByUsername(String username);
//	
//	Post findByPostID(String postID);
//	
//	List<Post> findByPostType(String postType);
//	
//}
