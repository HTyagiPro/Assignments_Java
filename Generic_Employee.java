import java.time.LocalDate;

public class Generic_Employee {
	private int e_id;
	transient private double salary;
	private String ename;
	private LocalDate dob;
	
	
	public Generic_Employee() {
		
	}
	
	
	public Generic_Employee(int e_id, double salary, String ename, LocalDate dob) {
		this.e_id = e_id;
		this.salary = salary;
		this.ename = ename;
		this.dob = dob;
	}

	/*
	public int validateId(int e_id) {
		if(e_id != 0)
			return e_id;
		else 
			throw new RuntimeException("ID can not be NULL");
	}

	public int getE_id() {
		return validateId(e_id);
	}
	public void setE_id(int e_id) {
		this.e_id = validateId(e_id);
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void getEname(String ename) {
		this.ename = ename;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	*/
	public String toString() {
		// TODO Auto-generated method stub
		return this.e_id +"\t" + this.ename + "\t" + this.salary;
	}

}











