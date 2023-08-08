package com.har.bootDemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@Column(name = "emp_id")
	private int empid;
	@Column(name = "emp_name")
	private String empname;
	@Column(name = "emp_sal")
	private double empsal;
	@Column(name = "dept_no")
	private int empdeptNo;
	
	



	/*
	@Autowired
	private Department department;
	 */
	public Employee() {
	}
	
	

	public Employee(int empid, String empname, double empsal, int empdeptNo) {
		this.empid = empid;
		this.empname = empname;
		this.empsal = empsal;
		this.empdeptNo = empdeptNo;
	}



	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}



	public String getEmpname() {
		return empname;
	}



	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public double getEmpsal() {
		return empsal;
	}



	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}


	public int getEmpdeptNo() {
		return empdeptNo;
	}



	public void setEmpdeptNo(int empdeptNo) {
		this.empdeptNo = empdeptNo;
	}


	@Override
	public String toString() {
		return "Employee:-\n------------------------------------\nEmployee ID: " + empid + "\nEmployee Name: " + empname + "\nEmployee Salary: " + empsal +"\nEmployee Dept. No.: "+empdeptNo;
	}
	
	
}
