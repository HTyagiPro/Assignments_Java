package com.har.liberary;

public class BookNotFoundException extends RuntimeException{
	String msg;

	public BookNotFoundException() {
	}




	public BookNotFoundException(String msg) {
		this.msg = msg;
	}




	public String getMessage(String msg) {
		return msg;
	}
	
	public String toString() {
		return "BookNotFoundException " +msg;
	}
}
