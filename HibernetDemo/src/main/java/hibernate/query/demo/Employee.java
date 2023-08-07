package  hibernate.query.demo;

import javax.persistence.*;
@Entity
@Table(name="emp")
public class Employee {
	@Id
	private int emp_id;
	private String emp_name;
	private double emp_sal;
	private int emp_deptNo;
	
	
	
	
	
	
	public Employee() {
	}
	public Employee(int emp_id, String emp_name, double emp_sal) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_sal = emp_sal;
		//this.emp_deptNo = emp_deptNo;    , int emp_deptNo
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public double getEmp_sal() {
		return emp_sal;
	}
	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}
	
	public int getEmp_deptNo() {
		return emp_deptNo;
	}
	public void setEmp_deptNo(int emp_deptNo) {
		this.emp_deptNo = emp_deptNo;
	}
	
	
	@Override
	public String toString() {
		return "Employee:-\n------------------------------------\nEmployee ID: " + emp_id + "\nEmployee Name: " + emp_name + "\nEmployee Salary: " + emp_sal + "\nEmployee Dept.: "
				+emp_deptNo+ "\n------------------------------------\n";
	}
	
	
}
