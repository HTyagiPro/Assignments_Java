package com.har.hibernet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private int add_id;
	private String add_Hno;
	private String add_street;
	private String add_city;
	private String add_state;
	
	@OneToOne(mappedBy="address")
	Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address() {
	}
	public Address(int add_id, String add_Hno, String add_street, String add_city, String add_state) {
		this.add_id = add_id;
		this.add_Hno = add_Hno;
		this.add_street = add_street;
		this.add_city = add_city;
		this.add_state = add_state;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getAdd_Hno() {
		return add_Hno;
	}
	public void setAdd_Hno(String add_Hno) {
		this.add_Hno = add_Hno;
	}
	public String getAdd_street() {
		return add_street;
	}
	public void setAdd_street(String add_street) {
		this.add_street = add_street;
	}
	public String getAdd_city() {
		return add_city;
	}
	public void setAdd_city(String add_city) {
		this.add_city = add_city;
	}
	public String getAdd_state() {
		return add_state;
	}
	public void setAdd_state(String add_state) {
		this.add_state = add_state;
	}
	@Override
	public String toString() {
		return "\nAddress:-\n\tAdd ID: " + add_id + "\n\tAdd H.No.: " + add_Hno + "\n\tAdd Street: " + add_street + "\n\tAdd City: "
				+ add_city + "\n\tAdd State: " + add_state + "\n------------------------------------\n";
	}
	
	
}
