package com.bptn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bptn.exceptions.InvalidUserCredentialsException;
import com.bptn.model.UserID;
import com.bptn.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/user/login")
	public ResponseEntity<?> validateUserCredentials(@RequestBody UserID userCred) throws InvalidUserCredentialsException {
		
		String loginDetails = loginService.validateUserCredentials(userCred);
		
		return new ResponseEntity<> (loginDetails, HttpStatus.OK);
	}
	

}
