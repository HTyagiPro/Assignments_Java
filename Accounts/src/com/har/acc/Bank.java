package com.har.acc;

public class Bank {
	private String bankName;
	private String branchName;
	private Account[] acc;
	public int noOfTransaction = 0;
	
	public Bank() {	}
	
	public Bank(String bankName, String branchName, Account[] acc) {
		this.bankName = bankName;
		this.branchName = branchName;
		this.acc = acc;
	}

	public void addAccount(Account a) throws AccountException {
		boolean added = false;
		for(int i=0; i<acc.length && added == false;i++) {
			if (acc[i] != null) {
				acc[i] = a;
				added = true;
			}
		}
		if(!added)
			throw new AccountException("Account Book Full!!!");
	}
	
	public String transactionForBank(char ttype,Account a,double amount) throws AccountException {
		if(noOfTransaction >= ((SavingAccount) a).getNoOfTransactionsPerDay())
			throw new AccountException("Transaction Limit Exceeded!!");
		switch(ttype) {
		case 'w':
			Transaction.withdraw(a, amount);
			noOfTransaction += 1;
			return "Transaction Successful\nAmount Withdraw: "+amount+" /-";
		case 'd':
			Transaction.deposite(a, amount);
			noOfTransaction += 1;
			return "Transaction Successful\n Amount Deposited: "+amount+" /-";
		default:
			throw new AccountException("Invalid Transaction!!!");
		}
		
	}
	
	public void showAccounts() {
		System.out.println("---------------Bank Details--------------");
		System.out.println("Bank Name: "+ this.getBankName());
		System.out.println("Branch Name: "+ this.getBranchName());
		System.out.println("-----------------------------------------");
		System.out.println("-------------Account Details-------------");
		for(int i=0; i<acc.length && acc[i] != null;i++) {
			System.out.println("Account Number: "+ acc[i].getAccountNo());
			System.out.println("Account Holder's Name: "+ acc[i].getName());
			System.out.println("Account Balance: "+ acc[i].getBalance());
			System.out.println("Account Type: "+acc[i].getClass().getSimpleName());
			
			if (acc[i].getClass().getSimpleName().equals("SavingAccount"))
				System.out.println("Per-day Transactions Limit: "+((SavingAccount) acc[i]).getNoOfTransactionsPerDay());
			else if  (acc[i].getClass().getSimpleName().equals("CurrentAccount"))
				System.out.println("Overdraft Limit: "+((CurrentAccount) acc[i]).getOverDraftLimit());
			
			System.out.println("Date of Account Opening : " + acc[i].dateOfOpening.getDayOfMonth()+"-"+acc[i].dateOfOpening.getMonthValue()+"-"+acc[i].dateOfOpening.getYear());
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
