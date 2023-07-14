package com.har.liberary;

public class BookStoreFullException extends RuntimeException {
	String msg;
	
	public BookStoreFullException() {
	}

	public BookStoreFullException(String msg) {
		this.msg = msg;
	}

	public String getMessage(String msg) {
		return msg;
	}
	
	public String toString() {
		return "BookStoreFullException " +msg;
	}
}
