import com.har.model.Employee;
import com.har.model.Address;
import com.har.model.Department;;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee[] eList = new Employee[5];
		
		
		
		
		
		eList[0] = new Employee(7001, "Ajay Saxena", 62500, new Address("02", "Swarg Ashram", "Hapur", "Uttar Pradesh"));
		eList[1] = new Employee(7002, "Mohan Saxena", 63500, new Address("20", "Swarg Ashram", "Rampur", "Uttar Pradesh"));
		eList[2] = new Employee(7003, "Sohan Saxena", 64500, new Address("25", "Swarg Ashram", "Lucknow", "Uttar Pradesh"));
		eList[3] = new Employee(7004, "Chinku Saxena", 65500, new Address("33", "Swarg Ashram", "Agra", "Uttar Pradesh"));
		eList[4] = new Employee(7005, "Pinku Saxena", 66500, new Address("39", "Swarg Ashram", "Mirzapur", "Uttar Pradesh"));
		
		Department d = new Department(101, "Sales & Marketing", "Meerut", eList);
		System.out.println("-------------------Department Details----------------------");
		System.out.println("Department Id : " + d.getDeptId());
		System.out.println("Department Name : " + d.getDeptName());
		System.out.println("Department Location : " + d.getDeptLocation());
		System.out.println("-----------------------------------------------------------\n\n");
		
		for(Employee e1 : eList) {
			System.out.println("Emp_Id : " + e1.getEmpId());
			System.out.println("E_Name : " + e1.getEmpName());
			System.out.println("Emp_Sal : " + e1.getSalary());
			System.out.println("---------Address-----------");
			System.out.println("House No.: \t" + e1.getAddress().gethNo());
			System.out.println("Street: \t" + e1.getAddress().getStreet());
			System.out.println("City:   \t" + e1.getAddress().getCity());
			System.out.println("State:  \t" + e1.getAddress().getState());
			System.out.println("----------------------------------------------------------\n\n");
			
		}
		
		
		
		/*
		System.out.println("Emp_Id : " + e1.getEmpId());
		System.out.println("E_Name : " + e1.getEmpName());
		System.out.println("Emp_Sal : " + e1.getSalary());
		System.out.println("---------Address-----------");
		System.out.println("House No.: \t" + e1.getAddress().gethNo());
		System.out.println("Street: \t" + e1.getAddress().getStreet());
		System.out.println("City:   \t" + e1.getAddress().getCity());
		System.out.println("State:  \t" + e1.getAddress().getState());
		*/
	}

}
