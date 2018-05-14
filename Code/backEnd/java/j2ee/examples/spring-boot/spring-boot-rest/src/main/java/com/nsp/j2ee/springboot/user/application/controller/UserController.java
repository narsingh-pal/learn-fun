package com.nsp.j2ee.springboot.user.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nsp.j2ee.springboot.user.application.util.CustomErrorType;
import com.nsp.j2ee.usermanagement.models.UserDetail;
import com.nsp.j2ee.usermanagement.service.UserDetailService;

import java.util.List;

import org.apache.log4j.Logger;


@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class UserController {
	public static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
    UserDetailService userDetailService; //Service which will do all data retrieval/manipulation work
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello Spring Boot is working!!";
	}
	
	
	// -------------------Retrieve All Users---------------------------------------------
	 
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<UserDetail>> listUsers() {
    	logger.info("Getting all user details");
        List<UserDetail> users = userDetailService.getAllUserDetails();
        
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserDetail>>(users, HttpStatus.OK);
    }
    
 // -------------------Retrieve Single User------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        logger.info("Fetching User with id " +  id);
        UserDetail user = userDetailService.getUserDetailById(id);
        if (user == null) {
            logger.error("User with id {} not found." + id);
            return new ResponseEntity(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDetail>(user, HttpStatus.OK);
    }
    
    // -------------------Create a User-------------------------------------------
    
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser( UserDetail userDetail, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : " + userDetail);
 
        if (userDetailService.isUserDetailExist(userDetail)) {
            logger.error("Unable to create. A User with name "+userDetail.getScreenName()+" already exist"   );
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A User with name " + 
            		userDetail.getScreenName() + " already exist."),HttpStatus.CONFLICT);
        }
        userDetailService.addNewUserDetail(userDetail);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(userDetail.getUserId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    // ------------------- Update a User ------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDetail user) {
        logger.info("Updating User with id {}" +  id);
 
        UserDetail currentUser = userDetailService.getUserDetailById(id);
 
        if (currentUser == null) {
            logger.error("Unable to update. User with id "+id+" not found." );
            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentUser.setUserId(user.getUserId());
        currentUser.setScreenName(user.getScreenName());
        currentUser.setEmail(user.getEmail());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
 
        userDetailService.updateUserDetail(currentUser);
        return new ResponseEntity<UserDetail>(currentUser, HttpStatus.OK);
    }
 
    // ------------------- Delete a User-----------------------------------------
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id " +  id);
 
        UserDetail user = userDetailService.getUserDetailById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id "+id+" not found." );
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userDetailService.removeUserDetail(user);
        return new ResponseEntity<UserDetail>(HttpStatus.NO_CONTENT);
    }
 
    
 
}