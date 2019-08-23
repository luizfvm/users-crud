package com.lf.restfulapi.resources.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lf.restfulapi.services.exception.ObjectNotFoundException;

/**
 * ResourceExceptionHandler class responsible for handling exceptions.
 */

@ControllerAdvice
public class ResourceExceptionHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
	
	/**
	 * Return a custom error message for ObjectNotFoundException.
	 * 
	 * @param e  ObjectNotFoundException object
	 * @param request  HttpServletRequest object
	 * @return HTTP 404 response code
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Date resultdate = new Date(System.currentTimeMillis());
		StandardError error = new StandardError(sdf.format(resultdate), status.value(), "Not Found", e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(error);

	}
	
	/**
	 * Return a custom error message for MethodArgumentNotValidException.
	 * 
	 * @param e  MethodArgumentNotValidException object
	 * @param request  HttpServletRequest object
	 * @return HTTP 400 response code
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> argumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Date resultdate = new Date(System.currentTimeMillis());
		ValidationError error = new ValidationError(sdf.format(resultdate), status.value(), "Bad Request", "Validation Error",
				request.getRequestURI());
		for ( FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(error);

	}

}
