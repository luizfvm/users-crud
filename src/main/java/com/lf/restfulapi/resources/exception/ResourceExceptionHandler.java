package com.lf.restfulapi.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lf.restfulapi.services.exception.ObjectNotFoundException;

/**
 * ResourceExceptionHandler class responsible for handling OjectNotFoundException
 */

@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Return a custom body error message
	 * @param e  ObjectNotFoundException object
	 * @param request  HttpServletRequest object
	 * @return HTTP 400 response code
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(error);

	}

}
