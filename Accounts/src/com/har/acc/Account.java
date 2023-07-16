/*
create a class Account with attributes
1. accountNo
2.openedDate
3.balance.
and provide constructors
getters and setters.
*/

package com.har.acc;
import java.time.LocalDate;

public class Account {
	private int accountNo;
	private String name;
	private double balance;
	LocalDate dateOfOpening;
	private double minimumDepositAmount;
	


	
	
	
	
	
	public Account(int accountNo, String name, double balance, LocalDate dateOfOpening, double minimumDepositAmount) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		this.dateOfOpening = dateOfOpening;
		this.minimumDepositAmount = minimumDepositAmount;
	}
	
	
	public LocalDate getDateOfOpening() {
		return dateOfOpening;
	}


	public void setDateOfOpening(LocalDate dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}


	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMinimumDepositAmount() {
		return minimumDepositAmount;
	}
	public void setMinimumDepositAmount(double minimumDepositAmount) {
		this.minimumDepositAmount = minimumDepositAmount;
	}



	
	
	
}
