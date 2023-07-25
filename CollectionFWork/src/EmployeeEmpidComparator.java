import java.util.Comparator;

public class EmployeeEmpidComparator  implements Comparator<Generic_Employee>{
	public int compare(Generic_Employee e1, Generic_Employee e2) {
		return e1.getE_id() - e2.getE_id();	
	}
}
