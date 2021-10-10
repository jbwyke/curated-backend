package com.revature.exceptions;

public class FollowNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5404874650856698214L;

	public FollowNotFoundException() {
		super();
	}

	public FollowNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FollowNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FollowNotFoundException(String message) {
		super(message);
	}

	public FollowNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
