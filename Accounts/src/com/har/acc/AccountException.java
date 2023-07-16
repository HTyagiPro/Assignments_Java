package com.har.acc;

public class AccountException extends RuntimeException {
	String msg;

	public AccountException() {
		
	}

	public AccountException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public String toString() {
		return "AccountException: " + msg;
	}
	
}
