import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Generic_Employee>{
	public int compare(Generic_Employee e1, Generic_Employee e2) {
		//Double.valueOf(e1.getSalary()).compareTo(e2.getSalary())
		return (int)(e1.getSalary()-e2.getSalary());	
	}
}
