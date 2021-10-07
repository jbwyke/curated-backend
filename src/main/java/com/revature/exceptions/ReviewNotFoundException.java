package com.revature.exceptions;

public class ReviewNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5220242108101914163L;

	public ReviewNotFoundException() {
		super();
	}

	public ReviewNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReviewNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReviewNotFoundException(String message) {
		super(message);
	}

	public ReviewNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
	
}
