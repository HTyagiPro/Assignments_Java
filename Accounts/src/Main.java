import com.har.acc.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] acc = null;
		Bank b = null;
		try {
			acc = new Account[10];
			b = new Bank("Reserve Bank of Spain", "Central Spain", acc);
			acc[0] = new SavingAccount(new Account(9563,"Cheeko1",1500.00),1000,5);
			acc[1] = new SavingAccount(new Account(9564,"Cheeko2",1500.00),1000,7);
			acc[2] = new CurrentAccount(9565,"Cheeko3",2000.00,250000);
			acc[3] = new Account(9566,"Cheeko4",1500.00);
			
			b.showAccounts();
			
		}catch(InsufficientBalanceException e) {
			System.out.println(e);
		}
		

	}

}
