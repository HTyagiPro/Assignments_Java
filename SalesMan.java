
public class SalesMan extends Employee {
	private int points;
	
	

	public SalesMan(int ssn, String name, int age, int e_id, double salary, String orgName, int points) {
		super(ssn, name, age, e_id, salary, orgName);
		this.points = points;
	}

	public SalesMan() {
		
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
