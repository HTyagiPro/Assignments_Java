package com.har.hibernet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.har.hibernet.entity.Employee;

public class EmployeeDAO {
	

	public EmployeeDAO() {
	}
	SessionFactory factory = null;

	public EmployeeDAO(SessionFactory factory) {
		this.factory = factory;
	}
	
	public void insertEmployee(Employee e) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(e);
			trans.commit();
			
		}catch (Exception e1) {
			// TODO: handle exception
			trans.rollback();
			System.out.println(e);
		}
		
	}
	
	public void deleteEmployee(Employee e) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.delete(e);
			trans.commit();
			
		}catch (Exception e1) {
			System.out.println(e);
		}
		
	}
	
	public void modifyEmployee(Employee e) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.update(e);
			trans.commit();
			
		}catch (Exception e1) {
			// TODO: handle exception
			trans.rollback();
			System.out.println(e);
		}
		
	}
	
	public Employee getEmployeeById(int id) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Employee e = null;
		try {
			e = session.get(Employee.class, id);
			
		}catch (Exception e1) {
			// TODO: handle exception
			System.out.println(e1);
			
		}
		
		return e;
		
	}
}
