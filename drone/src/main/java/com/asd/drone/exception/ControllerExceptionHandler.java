package com.asd.drone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=DroneLoadingException.class)
	public ResponseEntity<String> WeightLimitException(DroneLoadingException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
