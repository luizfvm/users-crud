package com.lf.restfulapi.resources.exception;

import java.io.Serializable;

/**
 * StandardError class responsible for implementing the error messages of MethodArgumentNotValidException.
 */

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String defaultMessage;

	public FieldMessage() {
		super();
	}

	public FieldMessage(String fieldName, String defaultMessage) {
		this.fieldName = fieldName;
		this.defaultMessage = defaultMessage;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
