/*
Create a class SavingsAccount by extending the Account class
and provide attributes  
1. minimumDepositAmount,
2. noOfTransactionsPerDay. 
Provide constructors , setters , getters and validation methods for above mentioned attributes.

*/

package com.har.acc;

public class SavingAccount extends Account{
	double minimumDepositAmount;
	 int noOfTransactionsPerDay;
	Account a;
	

	public SavingAccount(Account a, int noOfTransactionsPerDay) {
		super(a.getAccountNo(), a.getName(), a.getBalance(),a.getDateOfOpening(), a.getMinimumDepositAmount());
		this.noOfTransactionsPerDay = noOfTransactionsPerDay;
	}
	public int getNoOfTransactionsPerDay() {
		return noOfTransactionsPerDay;
	}
	public void setNoOfTransactionsPerDay(int noOfTransactionsPerDay) {
		this.noOfTransactionsPerDay = noOfTransactionsPerDay;
	}
	
}

