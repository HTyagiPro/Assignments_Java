import java.time.LocalDate;

public class Account {
	private long accNo;
	private String accHolderName;
	private LocalDate dateOfOpening;
	private double balance;
	private char status;
	public Account() {	}
	public Account(long accNo, String accHolderName,  LocalDate dateOfOpening, double balance, char status) {
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.dateOfOpening = dateOfOpening;
		this.balance = balance;
		this.status = status;
	}	
	
	public String toString() {
		return " Account No." + this.accNo + "\n Account Holder name:  " + this.accHolderName + "\n Account Balance: " + this.balance + "\n Date of A/c opening " + this.dateOfOpening + "\n Acc. Status: " + this.status;
	}
	
	public boolean equals(Object obj) {
        if (obj instanceof Account) {
        	Account a = (Account)obj;
        	return a.accNo == this.accNo && a.accHolderName.equals(this.accHolderName) && a.dateOfOpening.equals(this.dateOfOpening) && a.balance == this.balance && a.status == this.status;
        }
		return false;
    }
}

class Saving{
	int rateOfInterest;
	
}

class Current{
	
}

