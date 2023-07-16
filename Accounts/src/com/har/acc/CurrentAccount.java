package com.har.acc;

public class CurrentAccount extends Account {
	public double overDraftLimit;
	Account a;
	
	public CurrentAccount(Account a, double overDraftLimit) {
		super(a.getAccountNo(), a.getName(), a.getBalance(), a.getDateOfOpening(), a.getMinimumDepositAmount());
		this.overDraftLimit = validateOverDraft(overDraftLimit);
	}

	public double validateOverDraft(double overDraftLimit) {
		if (overDraftLimit <= 150000)
			return overDraftLimit;
		else 
			throw new AccountException("Overdraft limit exceeds!!!");
	}
	
	public double getOverDraftLimit() {
		return validateOverDraft(overDraftLimit);
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = validateOverDraft(overDraftLimit);
	}
	
}
