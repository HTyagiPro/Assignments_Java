package com.har.acc;

import java.time.LocalDate;

public class Transaction extends Account {

	public Transaction(int accountNo, String name, double balance,LocalDate dateOfOpening, double minimumDepositAmount) {
		super(accountNo, name, balance, dateOfOpening, minimumDepositAmount);
		// TODO Auto-generated constructor stub
	}
	
	public static void deposite(Account acc, double amount) {
		acc.setBalance(acc.getBalance()+ amount );
	}
	
	
	public static void withdraw(Account acc, double amount) {
		double bal = acc.getBalance();
		if (bal-amount >= acc.getMinimumDepositAmount())
			acc.setBalance(acc.getBalance()- amount );
		else
			throw new InsufficientBalanceException("Your funds are insufficient");
	}
	
}

