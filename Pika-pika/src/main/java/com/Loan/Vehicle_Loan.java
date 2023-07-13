package com.Loan;

public class Vehicle_Loan extends Loan {
	String registrationNo;
	int mktValue;
	String vehicleCategory;
	public Vehicle_Loan(int tenure, double roI, String registrationNo, int mktValue, String VehicleCategory) {
		super(tenure, roI);
		// TODO Auto-generated constructor stub
		this.registrationNo = registrationNo;
		this.mktValue = mktValue;
		this.loanAmount = this.mktValue*0.7;
		this.vehicleCategory = VehicleCategory;
		
		
		System.out.println(this.tenure);
		System.out.println(this.roI);
		System.out.println(this.loanAmount);
		System.out.println(this.mktValue);
	}
	
	public double calculateEMI()
	{
		return ((this.loanAmount + (this.loanAmount*this.tenure*this.roI)/100))/this.tenure;
	}
	
	
	
}
