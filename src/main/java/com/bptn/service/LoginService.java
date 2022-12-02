package com.bptn.service;


import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.model.AuthenticationUser;
import com.bptn.model.UserID;
import com.bptn.repository.AuthenticationUserRepository;
import com.bptn.request.LoginRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationUserRepository authenticationUserRepository;

    public UserID verifyUserCredentials(LoginRequest loginRequest) throws InvalidUserCredentialsException {
        LOGGER.debug("Invoking login = {}", "verifyUserCredentials");
        if (StringUtils.isEmpty(loginRequest.getUsername()) || StringUtils.isEmpty(loginRequest.getPassword())){
            LOGGER.debug("Username = {} or Password = {} can't be empty", loginRequest.getUsername(), loginRequest.getPassword());
            throw new InvalidUserCredentialsException("Username or Password can't be empty");
        }
        AuthenticationUser authenticationUser =
                authenticationUserRepository.findAuthenticationUserByIdAndUserPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (authenticationUser == null) {
            throw new InvalidUserCredentialsException("Invalid Credentials");
        }
        LOGGER.debug("Username = {} or Password = {} validated successfully", loginRequest.getUsername(), loginRequest.getPassword());
        return authenticationUser.getUserID();
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
//import com.bptn.exceptions.InvalidUserCredentialsException;
//import com.bptn.model.UserID;
//import com.bptn.repository.LoginRepository;
//
//@Service
//public class LoginService {
//	
//	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	private LoginRepository loginRepository;
//	
//	public String validateUserCredentials(UserID userCred) throws InvalidUserCredentialsException {
//		
//		List<UserID> userentity = loginRepository.getUserByUserId(userCred.getUsername());
//		
//		for(UserID u : userentity) {
//			
//			LOGGER.info("Retrieving username from the database");
//			
//			if (u.getUsername().equals(userCred.getUsername()))
//				
//				if (u.getPassword().equals(userCred.getPassword()))
//					
//					return "Login is Successful";
//			
//				else
//					
//					return "Password Incorrect" + new InvalidUserCredentialsException("Password does not match records");
//		}
//		
//		return "User login issue" + new InvalidUserCredentialsException("Username do not exist");
//	}
//
//}
