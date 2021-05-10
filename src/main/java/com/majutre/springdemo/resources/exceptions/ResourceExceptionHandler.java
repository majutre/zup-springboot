package com.majutre.springdemo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.majutre.springdemo.services.exceptions.DataIntegrityException;
import com.majutre.springdemo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<HttpStandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		
		HttpStandardError err = new HttpStandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), Instant.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<HttpStandardError> dataIntegrityError(DataIntegrityException e, HttpServletRequest req){
		
		HttpStandardError err = new HttpStandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), Instant.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
