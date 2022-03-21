package com.zensar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class ProductCreationFiailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432477129131415788L;
	private String message;
	
	public ProductCreationFiailureException() {
		super();
	}
	
	public ProductCreationFiailureException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProductCreationFiailureException [message=" + message + "]";
	}
}
