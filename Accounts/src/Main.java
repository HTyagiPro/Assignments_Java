import com.har.acc.*;
import java.time.LocalDate;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] acc = null;
		Bank b = null;
		try {
			acc = new Account[10];
			b = new Bank("Reserve Bank of Spain", "Central Spain", acc);
			acc[0] = new SavingAccount(new Account(9563,"Cheeko1",1500.00, LocalDate.of(2001,1,30), 1000),5);
			acc[1] = new SavingAccount(new Account(9564,"Cheeko2",1500.00,LocalDate.of(2003,6,1), 1000),7);
			acc[2] = new CurrentAccount(new Account(9565,"Cheeko3",2000.00,LocalDate.of(1997,8,8), 1000), 125000);
			acc[3] = new Account(9566,"Cheeko4",1500.00,LocalDate.of(1999,11,14), 1000);
			
			
			b.showAccounts();
			//System.out.println(b.transactionForBank('d', acc[3], 500));
			//b.showAccounts();
		}catch(InsufficientBalanceException e) {
			System.out.println(e);
		}
		

	}

}
