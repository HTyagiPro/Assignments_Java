package com.har.acc;

public class Test_Acc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account a1 = new Account(9563, "Cheeko", 1500);
		try {
		Transaction.withdraw(a1, 300.00);
		}
		catch(InsufficientBalanceException e){
			System.out.println(e);
			
		}
		System.out.println("Balance = Rs. "+ a1.getBalance()+"/-");
	}

}
