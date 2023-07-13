package com.Loan;

public class Test_Loan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loan l = null;
		l = LoanMela.loanSanction();
		
		System.out.println(l.calculateEMI());
		System.out.println(l.getClass());
	}

}
