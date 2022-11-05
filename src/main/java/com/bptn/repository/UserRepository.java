package com.bptn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bptn.model.UserID;

@Repository
public interface UserRepository extends JpaRepository<UserID, String> {
	
	@Query(value = "SELECT * FROM \"UserID\" WHERE username = 1?", nativeQuery=true)
	List<UserID> findbyUsername(String username);

}
