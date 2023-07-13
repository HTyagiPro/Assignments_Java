package com.Loan;
public class LoanMela {
	public static Loan loanSanction() {
		switch(new java.util.Random().nextInt()%3) {
		case 0:
			return new Personal_Loan(60, 12.0, 400000);
		case 1: 
			return new Vehicle_Loan(48, 7.5, "UP81CT5049", 1000000, "Commercial");
		default : 
			return new Home_Loan( 72, 7.0, "Delhi", 1800000);
		}
	}
}
