package com.Loan;

public class Personal_Loan extends Loan {
	double income;
	
	public Personal_Loan( int tenure, double roI, double income) {
		super(tenure, roI);
		// TODO Auto-generated constructor stub
		this.income = income;
		this.loanAmount = this.income*0.8;
		System.out.println(this.tenure);
		System.out.println(this.roI);
		System.out.println(this.loanAmount);
		System.out.println(this.income);
	}

	public double calculateEMI()
	{
		System.out.println((this.loanAmount*this.tenure*this.roI)/100);
		return ((this.loanAmount + (this.loanAmount*this.tenure*this.roI)/100))/this.tenure;
	}
	

	
	
}
