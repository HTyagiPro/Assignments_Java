package com.har.spcd.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	private int ssn=420;
	private String name="Ajay";
	private int age=32;
	
	private Address address;
	
	
	


	public Person(Address address) {
		this.address = address;
	}

	public Person(int ssn, String name, int age, Address address) {
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.setAddress(address);
	}

	public int validateAge(int age) {
		return age;
		
	}

	public Person() {
		
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





	public int getAge() {
		return this.validateAge(age);
	}





	public void setAge(int age) {
		this.age = this.validateAge(age);
	}

	public Address getAddress() {
		return address;
	}
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person:\n----------------\nSSN: " + ssn + "\nName: " + name + "\nAge: " + age + "\n----------------\n"+"\nAddress: " + address ;
	}
	
	

}
