package com.lf.restfulapi.resources.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * ValidationError class responsible for implementing the error fields, constructors and methods of MethodArgumentNotValidException.
 */

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> fieldError = new ArrayList<>();

	public ValidationError(String timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public void addError(String fieldName, String defaultMessage) {
		fieldError.add(new FieldMessage(fieldName, defaultMessage));
	}

	public List<FieldMessage> getFieldError() {
		return fieldError;
	}

}
