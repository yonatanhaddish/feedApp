package com.bptn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.model.History;

@Repository
public interface FeedHistoryRepository extends JpaRepository<History, String> {
	
	List<History> findByUsernameKey(String usernameKey);
	
	History findByPostID(String postID);
	
	List<History> findByPostType(String postType);
	
	@Transactional
	void deleteByPostType(String postType);

}
