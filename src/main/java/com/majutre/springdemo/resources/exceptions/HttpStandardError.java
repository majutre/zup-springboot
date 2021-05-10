package com.majutre.springdemo.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class HttpStandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String message;
	private Instant timestamp;
	
	public HttpStandardError() {
		
	}

	public HttpStandardError(Integer status, String message, Instant timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
