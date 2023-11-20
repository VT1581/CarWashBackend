package com.na.userAuthentication.exception;

import java.util.HashMap;
import java.util.Map;

 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 

//import org.hibernate.validator.internal.util.logging.Log_.logger;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

 

@ControllerAdvice
public class MainExceptionHandler {

 

	
	private static Logger logger = LogManager.getLogger(); 


	@ExceptionHandler(Exception.class)

 

	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {

 

 

		ErrorResponse exceptionResponse = new ErrorResponse(ex.getMessage());

 

		logger.info(ex.getMessage());

 

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

 

	}

 

	

 

	

 

 

 

	@ExceptionHandler(MethodArgumentNotValidException.class)

 

 

    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

 

 

        Map<String, String> errors = new HashMap<>();

 

 

        ex.getBindingResult().getAllErrors().forEach(error -> {

 

 

            String fieldName = ((FieldError) error).getField();

 

 

            String errorMessage = error.getDefaultMessage();

 

 

            errors.put(fieldName, errorMessage);

 

 

        });

 

 

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

 

 

    }
}
