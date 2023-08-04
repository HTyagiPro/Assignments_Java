import java.time.LocalDate;

public class MultiLevelInherit {
	
	
	public static void main(String[] args) {
		
		PGStudent pg1 = new PGStudent(104, "Ajay Saxena",24, 0021, 475,"IIT","PG", 3, "B-Tech", "M-Tech", "Networking");
		
	}
	
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account(7001, "Ajay Saxena", LocalDate.now(), 5000, 'A');
		Account a2 = new Account(7001, "Ajay Saxena", LocalDate.now(), 5000, 'C');
		System.out.println(a1.equals(a2));

	}
	*/

}

class A{
	int x = 50;

	public A() {
		System.out.println("A created");
	}
	
	public void message() {
		System.out.println("Hiii, I have sent u a message.");
	}
	
}

class B extends A{
	int y = 32;

	public B() {
		super();
		System.out.println("B created");
	}
	
	public void message() {
		System.out.println("Hey, i got ur message but didn't replied.");
	}
	
	
}

class C extends B{
	int z = 99;

	public C() {
		super();
		System.out.println("C created");
	}
	
}










