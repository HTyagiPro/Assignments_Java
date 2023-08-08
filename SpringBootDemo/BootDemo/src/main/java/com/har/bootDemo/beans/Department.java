package com.har.bootDemo.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity

public class Department {
	@Id
	@Column(name = "dept_no")
	private int deptno;
	@Column(name = "dept_name")
	private String deptname;
	@Column(name = "location")
	private String location;
	
	
	
	public Department() {
	}
	public Department(int deptno, String deptname, String location) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.location = location;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_no")
	List<Employee> employees;
	
	
	
	
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
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
		return "\nDepartment:-\n\tDepartment Name: " + deptno + "\n\tDepartment Name: " + deptname + "\n\tDepartment Location: " + location + "\n-------------------------------------\n";
	}
}