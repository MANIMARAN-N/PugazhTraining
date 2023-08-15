package com.example.customer;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

}