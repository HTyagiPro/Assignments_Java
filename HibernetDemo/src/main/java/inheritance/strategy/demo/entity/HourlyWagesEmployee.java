package inheritance.strategy.demo.entity;

import javax.persistence.*;
@Entity
//@DiscriminatorValue("HourlyWages")
public class HourlyWagesEmployee extends EmpSD{
	
	private int emp_NoHours;
	private double emp_rate;
	
	public HourlyWagesEmployee() {
	}

	public HourlyWagesEmployee(int emp_id, String emp_name, int emp_NoHours, double emp_rate) {
		super(emp_id, emp_name);
		this.emp_NoHours = emp_NoHours;
		this.emp_rate = emp_rate;
	}

	public int getEmp_NoHours() {
		return emp_NoHours;
	}

	public void setEmp_NoHours(int emp_NoHours) {
		this.emp_NoHours = emp_NoHours;
	}

	public double getEmp_rate() {
		return emp_rate;
	}

	public void setEmp_rate(double emp_rate) {
		this.emp_rate = emp_rate;
	}

	@Override
	public String toString() {
		return "Hourly Wages Employee:-\n\tNo. of Hours: " + emp_NoHours + "\n\tPer hour wages rate: " + emp_rate + "\n-*-*-*-*-*-*-*-*-*-*-*-*-*-\n";
	}

	

	
}
