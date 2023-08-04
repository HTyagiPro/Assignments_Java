
public class Employee extends Person {
	private int e_id;
	private double salary;
	private String orgName;
	
	
	
	public Employee() {
		
	}
	
	
	
	public Employee(int ssn, String name, int age, int e_id, double salary, String orgName) {
		super(ssn, name, age);
		this.e_id = e_id;
		this.salary = salary;
		this.orgName = orgName;
	}

	public int validateId(int e_id) {
		if(e_id != 0)
			return e_id;
		else 
			throw new InvalidIdException("ID can not be NULL");
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
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	
	
}
