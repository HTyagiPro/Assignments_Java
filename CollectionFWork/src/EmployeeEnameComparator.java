import java.util.Comparator;

public class EmployeeEnameComparator implements Comparator<Generic_Employee>{
	public int compare(Generic_Employee e1, Generic_Employee e2) {
		return e1.getEname().compareTo(e2.getEname());	
	}
}
