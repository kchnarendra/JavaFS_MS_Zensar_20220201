package com.zensar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CouponNotValidException extends RuntimeException {

	/**
	 * Exception CouponNotValidException
	 */
	private static final long serialVersionUID = -5498264836172162437L;
	private String message;
	
	public CouponNotValidException() {
		super();
	}
	
	public CouponNotValidException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "CouponNotValidException [message=" + message + "]";
	}

}
