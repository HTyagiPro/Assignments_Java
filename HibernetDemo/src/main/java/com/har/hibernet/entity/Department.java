package com.har.hibernet.entity;
import javax.persistence.*;
import java.util.List;


@Entity
public class Department {
	@Id
	private int dept_no;
	private String dept_name;
	private String location;
	
	/*
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="emp_deptNo")
	*/
	
	@OneToMany(mappedBy = "department")
	List<Employee> employees;
	
	
	public Department() {
	}
	public Department(int dept_no, String dept_name, String location) {
		this.dept_no = dept_no;
		this.dept_name = dept_name;
		this.location = location;
	}
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department:-\n-------------------------------------\n\tDepartment Name: " + dept_no + "\n\tDepartment Name: " + dept_name + "\n\tDepartment Location: " + location + "\n-------------------------------------\n";
	}
	
	
}
