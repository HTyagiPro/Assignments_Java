package com.har.spcd.beans.SpringAadhar;

import org.springframework.stereotype.Controller;

@Controller
public class AadharCard {
	private String aadharNo = "123456784321";

	public AadharCard() {
	}

	public AadharCard(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Override
	public String toString() {
		return "\n----------------------------------\n Aadhar No.: " + aadharNo + "\n----------------------------------\n";
	}
	
	
}
