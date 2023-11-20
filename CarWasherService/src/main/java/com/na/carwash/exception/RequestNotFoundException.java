package com.na.carwash.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RequestNotFoundException extends RuntimeException {

	public RequestNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
