package com.example.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerException {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> noProd(CustomerNotFoundException c) {
		return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
