package com.har.airModel;

import java.time.LocalDate;

public class Traveller {
	private String name;
	private String mobileNo;
	private String email;
	private String flightId;
	LocalDate date;
	
	
	
	public Traveller(String name, String mobileNo, String email, String flightId, LocalDate date) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.flightId = flightId;
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFlightId() {
		return flightId;
	}


	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Traveller: \n-------------------\nName: " + name + "\nMobile No: " + mobileNo + "\nEmail: " + email + "\nFlightId: " + flightId + "\nDate: " + date + "\n-------------------\n";
	}
	
	
	
	
}
