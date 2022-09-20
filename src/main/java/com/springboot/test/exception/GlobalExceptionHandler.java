package com.springboot.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception)
	{
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ResourceAlreadyExistException.class)
	public ResponseEntity<Object> handleResourceAlreadyExistException(ResourceAlreadyExistException exception)
	{
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
