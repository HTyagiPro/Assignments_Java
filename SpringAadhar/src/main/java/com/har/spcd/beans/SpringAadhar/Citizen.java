package com.har.spcd.beans.SpringAadhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Citizen {
	
	
	private String name = "Vijay";
	private int age = 22;
	private String address = "Abc Colony";
	@Autowired
	private AadharCard aadharNo;
	
	
	public Citizen() {
	}

	public Citizen(String name, int age, String address, AadharCard aadharNo) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.aadharNo = aadharNo;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AadharCard getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(AadharCard aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Override
	public String toString() {
		return "Citizen\n----------------------------------\nName: " + name + "\nAge: " + age + "\nAddress: " + address +  aadharNo;
	}

	
	
	

}
