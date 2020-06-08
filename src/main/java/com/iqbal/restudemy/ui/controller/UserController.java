package com.iqbal.restudemy.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iqbal.restudemy.ui.exception.UserServiceException;
import com.iqbal.restudemy.ui.model.response.UpdateUserDetails;
import com.iqbal.restudemy.ui.model.response.UserDetails;
import com.iqbal.restudemy.ui.model.response.UserRest;
import com.iqbal.restudemy.ui.service.UserService;

@RestController
@RequestMapping("users")   //http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	Map<String, UserRest> users;

    @GetMapping
    public String getUser(@RequestParam(value="page", defaultValue="1") int page, 
    		@RequestParam(value="limit", defaultValue="50") int limit,
    		@RequestParam(value="sort",defaultValue="desc", required=false) String sort)
    {
        return "get user was called "+page+" Limit "+limit+ " sort "+sort;
    }
    
    @GetMapping(path="/{userId}", produces= {MediaType.APPLICATION_XML_VALUE,
    										 MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
    	/*UserRest returnValue = new UserRest();
    	returnValue.setFirstName("Iqbal");
    	returnValue.setLastName("Hossain");
    	returnValue.setEmail("iqbal.cse2016@gmail.com");
    	returnValue.setPassword("1");*/
    	if (true) throw new UserServiceException("A user service exception is throw");
    	
    	if (users.containsKey(userId)) {
    		return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        
    }

    @PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,
			 			    MediaType.APPLICATION_JSON_VALUE},
		    	produces= {MediaType.APPLICATION_XML_VALUE,
						   MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetails userDetails){
    	/*UserRest returnValue = new UserRest();
    	returnValue.setFirstName(userDetails.getFirstName());
    	returnValue.setLastName(userDetails.getLastName());
    	returnValue.setEmail(userDetails.getEmail());
    	String userId = UUID.randomUUID().toString();
    	returnValue.setUserId(userId);
    	
    	
    	if (users == null)  {
    		users = new HashMap<>();
    		users.put(userId, returnValue);
		}*/
    	UserRest returnValue=userService.createUser(userDetails);
    	
    	return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path="/{userId}", consumes= {MediaType.APPLICATION_XML_VALUE,
			    		   MediaType.APPLICATION_JSON_VALUE},
    			produces= {MediaType.APPLICATION_XML_VALUE,
    					   MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser( @PathVariable String userId,@Valid @RequestBody UpdateUserDetails userDetails ){
    	UserRest returnValue = new UserRest();
    	returnValue.setFirstName(userDetails.getFirstName());
    	returnValue.setLastName(userDetails.getLastName());
    	users.put(userId, returnValue);
    	return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteeUser(@PathVariable String id){
    	users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
