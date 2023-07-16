package com.har.acc;

public class InsufficientBalanceException extends RuntimeException {
	String msg;

	public InsufficientBalanceException() {
		
	}

	public InsufficientBalanceException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public String toString() {
		return msg;
	}
	
}