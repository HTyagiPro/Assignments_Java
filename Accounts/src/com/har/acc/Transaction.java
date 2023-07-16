package com.har.acc;

public class Transaction extends Account {

	public Transaction(int accountNo, String name, double balance) {
		super(accountNo, name, balance);
		// TODO Auto-generated constructor stub
	}
	
	public static void deposite(Account acc, double amount) {
		acc.setBalance(acc.getBalance()+ amount );
	}
	
	
	public static void withdraw(Account acc, double amount) {
		double bal = acc.getBalance();
		if (bal-amount >= 1000)
			acc.setBalance(acc.getBalance()- amount );
		else
			throw new InsufficientBalanceException("Your funds are insufficient");
	}
	
}

