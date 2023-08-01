package com.har.spcd.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Address {
	private int hNo=5;
	private String street="SW Road";
	private String city="Hapur";
	private String state="U.P.";
	public Address() {
	}
	public Address(int hNo, String street, String city, String state) {
		this.hNo = hNo;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "\n----------------\nH.No: " + hNo + "\nStreet: " + street + "\nCity: " + city + "\nState: " + state + "\n----------------\n";
	}
	
	
}
