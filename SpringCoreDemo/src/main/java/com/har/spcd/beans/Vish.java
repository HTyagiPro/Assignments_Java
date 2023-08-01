package com.har.spcd.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Vish {
	private String message;
	
	public Vish() {
		System.out.println("Bean of object created.");
	}
	

	public Vish(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void vishInit() {
		System.out.println("Haaayyyy Bean is initialized");
	}

	public void vishDestroy() {
		System.out.println("Bye Bye Bean is about to destroy");
	}

	/*

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ok");
		
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bai bai...");
		
	}
	*/
	
	

}
