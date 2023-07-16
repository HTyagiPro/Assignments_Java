package com.har.acc;

public class SavingAccount extends Account{
	private double minimumDepositAmount;
	int noOfTransactionsPerDay;
	Account a;
	
		
	

	public SavingAccount(Account a, double minimumDepositAmount,
			int noOfTransactionsPerDay) {
		super(a.getAccountNo(), a.getName(), a.getBalance());
		this.minimumDepositAmount = minimumDepositAmount;
		this.noOfTransactionsPerDay = noOfTransactionsPerDay;
		this.a = a;
	}
	public double getMinimumDepositAmount() {
		return minimumDepositAmount;
	}
	public void setMinimumDepositAmount(double minimumDepositAmount) {
		this.minimumDepositAmount = minimumDepositAmount;
	}
	public int getNoOfTransactionsPerDay() {
		return noOfTransactionsPerDay;
	}
	public void setNoOfTransactionsPerDay(int noOfTransactionsPerDay) {
		this.noOfTransactionsPerDay = noOfTransactionsPerDay;
	}
	
}
