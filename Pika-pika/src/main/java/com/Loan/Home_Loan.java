package com.Loan;

public class Home_Loan extends Loan {
	String location;
	double propertyValue;
	
	
	public Home_Loan( int tenure, double roI, String location, double propertyValue) {
		super(tenure, roI);
		this.location = location;
		this.loanAmount = propertyValue*0.9;
		this.propertyValue = propertyValue;
		
		
		System.out.println(this.tenure);
		System.out.println(this.roI);
		System.out.println(this.loanAmount);
		System.out.println(this.propertyValue);
	}


	public double calculateEMI()
	{
		return ((this.loanAmount + (this.loanAmount*this.tenure*this.roI)/100))/this.tenure;
	}
	
	
}

