package com.lf.restfulapi.services.exception;

/**
 * ObjectNotFoundException class responsible for generating a custom exception when searching for a non existent user.
 */

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String msg) {
		super(msg);
	}

}
