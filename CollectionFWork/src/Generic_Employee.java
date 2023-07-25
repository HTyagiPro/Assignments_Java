import java.time.LocalDate;

public class Generic_Employee implements Comparable<Generic_Employee>{
	private int e_id;
	private double salary;
	private String ename;
	public Generic_Employee() {
		
	}
	
	
	public Generic_Employee(int e_id, double salary, String ename, LocalDate dob) {
		this.e_id = e_id;
		this.salary = salary;
		this.ename = ename;
	}

	
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

/*
	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
*/	
	public String toString() {
		// TODO Auto-generated method stub
		return this.e_id +"\t" + this.ename + "\t" + this.salary + "       ";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Generic_Employee) {
			Generic_Employee e = (Generic_Employee)obj; 
			return this.e_id == e.e_id && this.ename.equals(e.ename) && this.salary == e.salary;
		}
		return false;
	}
	
	public int hashCode() {
		return Integer.valueOf(this.e_id).hashCode() + (this.ename).hashCode()+ Double.valueOf(this.salary).hashCode();
	}
	
	public int compareTo(Generic_Employee e) {
		return this.hashCode() - e.hashCode();
	}
	
}











