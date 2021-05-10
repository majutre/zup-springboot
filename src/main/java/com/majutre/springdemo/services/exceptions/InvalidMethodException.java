package com.majutre.springdemo.services.exceptions;

public class InvalidMethodException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public InvalidMethodException(String msg) {
			super(msg);
		}
		
		public InvalidMethodException(String msg, Throwable cause) {
			super(msg, cause);
		}

}
