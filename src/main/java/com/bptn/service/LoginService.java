package com.bptn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.model.UserID;
import com.bptn.repository.LoginRepository;

@Service
public class LoginService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginRepository loginRepository;
	
	public String validateUserCredentials(UserID userCred) throws InvalidUserCredentialsException {
		
		List<UserID> userentity = loginRepository.getUserByUserId(userCred.getUsername());
		
		for(UserID u : userentity) {
			
			LOGGER.info("Retrieving username from the database");
			
			if (u.getUsername().equals(userCred.getUsername()))
				
				if (u.getPassword().equals(userCred.getPassword()))
					
					return "Login is Successful";
			
				else
					
					return "Password Incorrect" + new InvalidUserCredentialsException("Password does not match records");
		}
		
		return "User login issue" + new InvalidUserCredentialsException("Username do not exist");
	}

}
