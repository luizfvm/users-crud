package com.lf.restfulapi.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lf.restfulapi.services.exception.ObjectNotFoundException;
import com.lf.restfulapi.util.DateFormatter;

/**
 * ResourceExceptionHandler class responsible for handling exceptions.
 */

@ControllerAdvice
public class ResourceExceptionHandler {

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
		StandardError error = new StandardError(DateFormatter.formatToISO8601(), status.value(), "Not Found",
				e.getMessage(), request.getRequestURI());
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
	public ResponseEntity<StandardError> argumentNotValid(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError error = new ValidationError(DateFormatter.formatToISO8601(), status.value(), "Bad Request",
				"Validation Error", request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(error);

	}

}
