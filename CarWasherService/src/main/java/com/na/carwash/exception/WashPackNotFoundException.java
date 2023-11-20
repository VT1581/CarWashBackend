package com.na.carwash.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WashPackNotFoundException extends RuntimeException {

	public WashPackNotFoundException(String message) {
		super(message);
	}


	
}
