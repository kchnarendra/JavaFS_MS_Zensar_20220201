package com.narendra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PostIdNotAvailableException extends RuntimeException {

	
	private String message;
	

	public PostIdNotAvailableException() {
		super();
	}
	
	public PostIdNotAvailableException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "PostIdNotAvailableException [message=" + message + "]";
	}
	
	
}
