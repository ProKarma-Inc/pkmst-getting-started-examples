package com.prokarma.pkmst.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.User;
import com.prokarma.pkmst.model.UserRepository;
import com.prokarma.pkmst.service.UserDetailServiceImpl;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-30T06:10:08.321Z")

@Controller
public class UserApiController implements UserApi {
    private final ObjectMapper objectMapper;
@Autowired
    public UserApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	private boolean loggedInUser = false;

    public ResponseEntity<String> createUser(@ApiParam(value = "Created user object" ,required=true )   @RequestBody User body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        
    	String message;
    	if(!loggedInUser) {
    		message = "You are not authorised user to add a user to the system. Please check with your adminstrator!";
    	} else {
    		repository.save(body);
    		message = body.getUsername() + "user registered with the system";
    	}

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<String>(message,HttpStatus.OK);
        }
        return new ResponseEntity<String>(message,HttpStatus.OK);

    }

    public ResponseEntity<String> createUsersWithArrayInput(@ApiParam(value = "List of user object" ,required=true )   @RequestBody List<User> body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	String message;
    	if(!loggedInUser) {
    		message = "You are not authorised user to add user(s) to the system. Please check with your adminstrator!";
    	} else {
    		for (User user : body) {
    			repository.save(user);
			}    		
    		message = "User(s) registered with the system";
    	}
        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<String>(message,HttpStatus.OK);
        }

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    public ResponseEntity<String> createUsersWithListInput(@ApiParam(value = "List of user object" ,required=true )   @RequestBody List<User> body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	String message;
    	if(!loggedInUser) {
    		message = "You are not authorised user to add user(s) to the system. Please check with your adminstrator!";
    	} else {
    		for (User user : body) {
    			repository.save(user);
			}    		
    		message = "User(s) registered with the system";
    	}
        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<String>(message,HttpStatus.OK);
        }

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true ) @PathVariable("username") String username,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	String message;
    	if(!loggedInUser) {
    		message = "You are not authorised user to add a user to the system. Please check with your adminstrator!";
    	} else {
    		repository.delete(repository.findByUsername(username).getId());
    		message = username + " deleted successfully from the system";
    	}

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<String>(message,HttpStatus.OK);
        }
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user for testing. ",required=true ) @PathVariable("username") String username,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

    	String message;
    	if(!loggedInUser) {
    		return new ResponseEntity<User>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    	}
    	if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<User>(repository.findByUsername(username), HttpStatus.OK);
        }

        return new ResponseEntity<User>(repository.findByUsername(username),HttpStatus.OK);
    }

    public ResponseEntity<String> loginUser(@ApiParam(value = "The user name for login", required = true)  @RequestParam(value = "username", required = true) String username,
        @ApiParam(value = "The password for login in clear text", required = true)  @RequestParam(value = "password", required = true) String password,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        
    	String message;
    	if(userDetailsService.loadUserByUsernamePassword(username,password) != null) {
    		loggedInUser = true;
    		message = "User logged in successfully into the system";
    	} else {
    		loggedInUser = false;
    		message = "Login failed. Please try again with correct username and password.";
    	}

        if (accept != null && accept.contains("application/xml")) {
        	return new ResponseEntity<>(message,HttpStatus.OK);
        }

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<>(message,HttpStatus.OK);
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    public ResponseEntity<String> logoutUser(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	loggedInUser = false;

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>("Logged out successfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Logged out successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> updateUser(@ApiParam(value = "name that need to be updated",required=true ) @PathVariable("username") String username,
        @ApiParam(value = "Updated user object" ,required=true )   @RequestBody User body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	
    	String message;
    	if(!loggedInUser) {
    		message = "You are not authorised for this operation to do. Please check with your adminstrator!";
    	}  else {
    		repository.save(body);
    		message = "User information modified successfully.";
    	}

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
