package com.har.acc;

public class CurrentAccount extends Account {
	public double overDraftLimit;
	Account[] acc;
	
	public CurrentAccount(int accountNo, String name, double balance, double overDraftLimit) {
		super(accountNo, name, balance);
		this.overDraftLimit = overDraftLimit;
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
}
