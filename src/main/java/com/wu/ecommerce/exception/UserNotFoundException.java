package com.wu.ecommerce.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return super.getMessage();
	}
}
