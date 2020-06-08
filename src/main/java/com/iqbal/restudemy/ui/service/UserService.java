/**
 * 
 */
package com.iqbal.restudemy.ui.service;

import com.iqbal.restudemy.ui.model.response.UserDetails;
import com.iqbal.restudemy.ui.model.response.UserRest;

/**
 * @author SONY
 *
 */
public interface UserService {
	
	UserRest createUser(UserDetails userDetails);

}
