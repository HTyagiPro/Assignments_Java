package com.har.acc;

public class Bank {
	private String bankName;
	private String branchName;
	private Account[] acc;
	
	public Bank() {	}
	
	public Bank(String bankName, String branchName, Account[] acc) {
		this.bankName = bankName;
		this.branchName = branchName;
		this.acc = acc;
	}

	public boolean addAccount(Account a) throws InsufficientBalanceException {
		boolean added = false;
		for(int i=0; i<acc.length && added == false;i++) {
			if (acc[i] != null) {
				acc[i] = a;
				added = true;
			}
			
		}
		if(!added)
			throw new InsufficientBalanceException("Account Book Full!!!");
		return added;
	}
	
	public void showAccounts() {
		System.out.println("---------------Bank Details---------------");
		System.out.println("Account Number: "+ this.getBankName());
		System.out.println("Account Holder's Name: "+ this.getBranchName());
		System.out.println("-----------------------------------------");
		for(Account a:acc) {
			System.out.println("-------------Account Details-------------");
			System.out.println("Account Number: "+ a.getAccountNo());
			System.out.println("Account Holder's Name: "+ a.getName());
			System.out.println("Account Balance: "+ a.getBalance());
			System.out.println("-----------------------------------------");
			
		}
	}
	
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Account[] getAccounts() {
		return acc;
	}

	public void setAccounts(Account[] acc) {
		this.acc = acc;
	}

	
	
	
}
