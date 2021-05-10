package com.majutre.springdemo.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends HttpStandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String message, Instant timestamp) {
		super(status, message, timestamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
