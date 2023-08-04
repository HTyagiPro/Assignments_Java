//import java.time.LocalDate;
//import java.time.LocalTime;
import java.time.LocalDateTime;

public class Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LocalDate ld = LocalDate.now();
		//LocalTime lt = LocalTime.now();
		SalesMan sm1 =null;
		LocalDateTime ldt = LocalDateTime.now();
		try {
		sm1 = new SalesMan(7701, "Ajay Saxena", 14,5670,67000,"ABC_Corp.", 9);
		}catch(InvalidAgeException e) {
			System.out.println(e);
		}
		
		if (sm1 !=null) {
		System.out.println("SSN : " + sm1.getSsn());
		System.out.println("Name : " + sm1.getName());
		System.out.println("Age : " + sm1.getAge());
		System.out.println("Emp_Id : " + sm1.getE_id());
		System.out.println("Salary : " + sm1.getSalary() + "/-");
		System.out.println("Organization Name : " + sm1.getOrgName());
		System.out.println("Points achived : " + sm1.getPoints());
		System.out.println("Total Incentives: " + 750*sm1.getPoints() + "/-");
		System.out.println("Total Salary: " + (750*sm1.getPoints()+sm1.getSalary()) +  "/-");
		//System.out.println("Date : " + ld.getDayOfMonth()+"-"+ld.getMonthValue()+"-"+ld.getYear());
		//System.out.println("Time : " + lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond());
		
		System.out.println("Date : " + ldt.getDayOfMonth()+"-"+ldt.getMonthValue()+"-"+ldt.getYear());
		System.out.println("Time : " + ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
		}
	}

}

