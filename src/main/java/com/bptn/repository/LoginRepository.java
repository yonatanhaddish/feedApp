package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bptn.model.UserID;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<UserID, String> {
	
	@Query(value = "SELECT * FROM public.\"UserID\" WHERE username=?1", nativeQuery=true)
	List<UserID> getUserByUserId(String username);
}
