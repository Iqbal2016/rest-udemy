package com.iqbal.restudemy.ui.exception;

public class UserServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 12345567899452L;
	
	public UserServiceException(String message) {
		super(message);
	}

}
