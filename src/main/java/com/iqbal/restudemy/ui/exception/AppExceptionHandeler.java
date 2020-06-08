/**
 * 
 */
package com.iqbal.restudemy.ui.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.iqbal.restudemy.ui.model.response.ErrorMessage;

/**
 * @author SONY
 *
 */
@ControllerAdvice
public class AppExceptionHandeler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handelException(Exception ex, WebRequest request)
	{
		String errorMassageDescription = ex.getLocalizedMessage();
		if (errorMassageDescription == null) {
			ex.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMassageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handelNullPointerException(NullPointerException ex, WebRequest request)
	{
		String errorMassageDescription = ex.getLocalizedMessage();
		if (errorMassageDescription == null) {
			ex.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMassageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handelUserServiceException(UserServiceException ex, WebRequest request)
	{
		String errorMassageDescription = ex.getLocalizedMessage();
		if (errorMassageDescription == null) {
			ex.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMassageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*@ExceptionHandler(value= {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handelNullPointerException(NullPointerException ex, WebRequest request)
	{
		String errorMassageDescription = ex.getLocalizedMessage();
		if (errorMassageDescription == null) {
			ex.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMassageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}	
*/
}
