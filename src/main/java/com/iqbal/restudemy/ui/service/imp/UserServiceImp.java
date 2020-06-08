/**
 * 
 */
package com.iqbal.restudemy.ui.service.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.iqbal.restudemy.ui.model.response.UserDetails;
import com.iqbal.restudemy.ui.model.response.UserRest;
import com.iqbal.restudemy.ui.service.UserService;

/**
 * @author SONY
 *
 */

@Service
public class UserServiceImp implements UserService {
	
	Map<String, UserRest> users;

	/* (non-Javadoc)
	 * @see com.iqbal.restudemy.ui.service.UserService#createUser(com.iqbal.restudemy.ui.model.response.UserDetails)
	 */
	@Override
	public UserRest createUser(UserDetails userDetails) {
		UserRest returnValue = new UserRest();
    	returnValue.setFirstName(userDetails.getFirstName());
    	returnValue.setLastName(userDetails.getLastName());
    	returnValue.setEmail(userDetails.getEmail());
    	String userId = UUID.randomUUID().toString();
    	returnValue.setUserId(userId);
    	
    	
    	if (users == null)  {
    		users = new HashMap<>();
    		users.put(userId, returnValue);
		}
    	return returnValue;
	}

}
