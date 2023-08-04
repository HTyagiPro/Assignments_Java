package com.har.acc;

class InsufficientBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		return "InsufficientBalanceException: " + msg;
	}
	
}
