package com.bptn.service;

import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.model.UserID;
import com.bptn.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public void validateUserId(String username) throws InvalidUserNameException {
        UserID userID = userRepository.findByUsername(username);
        if (userID == null) {
            LOGGER.error("Username={} doesn't exist", username);
            throw new InvalidUserNameException("Username doesn't exist");
        } else {
            LOGGER.debug("Username={} validated", username);
        }
    }
}

//package com.bptn.service;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bptn.exceptions.InvalidUserNameException;
//import com.bptn.model.UserID;
//import com.bptn.repository.UserRepository;
//
//@Service
//public class UserService {
//	
//	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public void validateUserId(String username) throws InvalidUserNameException {
//		
//		List<UserID> userIDlist = userRepository.findbyUsername(username);
//		
//		if (userIDlist == null || userIDlist.isEmpty()) {
//			
//			LOGGER.error("Username = {} does not exists", username);
//			throw new InvalidUserNameException("Username does not exist");
//		}
//		else {
//			LOGGER.debug("Username = {} validated", username);
//		}
//	}
//
//}
