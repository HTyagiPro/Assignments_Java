package com.har.hibernet.entity;
import javax.persistence.*;

@Entity
public class Person {
	@Id
	private int ssn;
	private String name;
	private String gender;
	
	@OneToOne
	@JoinColumn(name="add_id")
	Address address;

	public Person() {
	}

	public Person(int ssn, String name, String gender, Address address) {
		this.ssn = ssn;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person:-\n------------------------------------\nSSN: " + ssn + "\nName: " + name + "\nGender: " + gender + address ;
	}
	
	
	
	
}
