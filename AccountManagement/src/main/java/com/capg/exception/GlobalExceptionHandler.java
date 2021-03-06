package com.capg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> IdNotFoundExceptionHandler(IdNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	}
}
