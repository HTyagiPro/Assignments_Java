package com.har.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.har.hibernet.dao.EmployeeDAO;
import com.har.hibernet.entity.Address;
import com.har.hibernet.entity.Courses;
import com.har.hibernet.entity.Department;
import com.har.hibernet.entity.Employee;
import com.har.hibernet.entity.Person;
import com.har.hibernet.entity.Student;
import com.har.hibernet.util.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	SessionFactory factory = HibernateUtility.buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction trans = session.beginTransaction();
    	
    	//save
    	
    	/*
    	Employee e = new Employee(107, "L.L.D.B.", 65200, 10);
    	Transaction trans = session.beginTransaction();	
    	session.save(e);
    	trans.commit();
    	*/
    	
    	//get
    	
    	/*
    	Employee e = session.get(Employee.class, 111);
    	System.out.println(e);
    	e.setEmp_name("Dhananjya Rajput");
    	e = session.get(Employee.class, 111);
    	System.out.println(e);
    	System.out.println("Session Dirty:" + session.isDirty());
    	Transaction trans = session.beginTransaction();
    	trans.commit();
    	System.out.println("Session Dirty:" + session.isDirty());
    	*/
    	
    	//update
    	
    	/*
    	Employee e1 = new Employee(108, "Naina", 65200, 10);
    	session.update(e1);
    	Transaction trans = session.beginTransaction();
    	trans.commit();
    	*/
    	
    	//saveOrUpdate- if object not exist it will insert and if object already existed it updates the changes
    	
    	/*
    	Employee e1 = new Employee(108, "Naina", 4200, 10);
    	session.saveOrUpdate(e1);
    	Transaction trans = session.beginTransaction();
    	trans.commit();
    	*/
    	
    	/*
    	Employee e = session.get(Employee.class, 119);
    	System.out.println(e);
    	session.delete(e);
    	Transaction trans = session.beginTransaction();
    	trans.commit();
    	e = session.get(Employee.class, 119);
    	System.out.println(e);
    	*/
    	
    	/*
    	EmployeeDAO edao = new EmployeeDAO(factory);
    	edao.insertEmployee(new Employee(104, "Ranjana", 4300, 50));
    	System.out.println(session.get(Employee.class, 104));
    	edao.modifyEmployee(new Employee(107, "L.L.D.B.", 6200, 30));
    	System.out.println(session.get(Employee.class, 107));
    	edao.deleteEmployee(new Employee(119,"",0,0));
    	*/
    	/*
    	Address a1 = new Address(7003, "1-9-8", "KV Road", "Kanpur", "U.P." );
    	Person p1 = new Person(102, "L.L.D.B.", "F", a1);
    	
    	session.save(a1);
    	session.save(p1);
    	
    	trans.commit();
    	*/
    	
    	/*
    	Person p = session.get(Person.class, 101);
    	Address a = session.get(Address.class, 7001);
    	//if(p!=null) System.out.println(p);
    	if(a!=null) {
    		//System.out.println(a);
    		System.out.println(a.getPerson());
    	}
    	*/
    	
    	/*
    	
    	Department d = session.get(Department.class, 20);
    	//session.delete(d);
    
    	if(d!= null) {
    		System.out.println(d);
    		
    		for(Employee e:d.getEmployees())
    			System.out.println(e);
    	}
    	
    	Employee e = session.get(Employee.class, 101);
    	//session.delete(d);
    
    	if(e!= null) {
    		System.out.println(e);
    	}
    	
    	//trans.commit();
    	 
    	 
    	
    	 */
    	
    	

    	
    	Courses c = session.get(Courses.class, "Core Java");
    	if(c!=null) {
    		System.out.println(c);
    		for(Student s:c.getStudent())
    			System.out.println(s);
    	}
    	
    	System.out.println("|****************************************************************************|");
    	
    	Student s = session.get(Student.class, 502);
    	if(s!=null) {
    		System.out.println(s);
    		for(Courses c2: s.getCourses())
    			System.out.println(c2);
    	}
    	
    	
    	session.close();
    	HibernateUtility.shutDown();
    	
    }
}
