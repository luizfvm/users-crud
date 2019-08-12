package com.lf.restfulapi.resources.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
	
	/**
	 * Return a custom body error message
	 * @param e  ObjectNotFoundException object
	 * @param request  HttpServletRequest object
	 * @return HTTP 400 response code
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Date resultdate = new Date(System.currentTimeMillis());
		StandardError error = new StandardError(sdf.format(resultdate), status.value(), "Not found", e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(error);

	}

}
