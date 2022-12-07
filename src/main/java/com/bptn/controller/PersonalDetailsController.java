package com.bptn.controller;

import com.bptn.model.Address;
import com.bptn.model.AuthenticationUser;
import com.bptn.model.Profile;
import com.bptn.model.UserID;
import com.bptn.request.AddressRequest;
import com.bptn.service.PersonalDetailsService;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonalDetailsController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @PutMapping("/user/personal/security")
    public ResponseEntity<?> securityUpdate(@RequestBody AuthenticationUser authenticationUser)  {
        LOGGER.debug("securityUpdate request received = {}", authenticationUser);
        authenticationUser = personalDetailsService.securityUpdate(authenticationUser);
        return new ResponseEntity<>(authenticationUser, HttpStatus.OK);
    }


    @PutMapping("/user/personal/profile")
    public ResponseEntity<?> profileUpdate(@RequestBody Profile profile)  {
        LOGGER.debug("profileUpdate request received = {}", profile);
        profile = personalDetailsService.profileUpdate(profile);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
    
    @PutMapping("/user/personal/address")
    public ResponseEntity<?> addressUpdate(@RequestBody AddressRequest addressRequest)  {
        LOGGER.debug("addressUpdate request received = {}", addressRequest);
        UserID userID = personalDetailsService.addressUpdate(addressRequest);
        return new ResponseEntity<>(userID, HttpStatus.OK);
    }
    
    @GetMapping("/user/basicprofile/{username}")
    public ResponseEntity<?> userBasicProfile(@PathVariable("username") String username)  {
        LOGGER.debug("userBasicProfile request received = {}", username);
        Profile profile = personalDetailsService.getProfile(username);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


    @GetMapping("/user/address/{username}")
    public ResponseEntity<?> userAddress(@PathVariable("username") String username)  {
        LOGGER.debug("userAddress request received = {}", username);
        Set<Address> address = personalDetailsService.getAddress(username);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}