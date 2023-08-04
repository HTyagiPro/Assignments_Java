package com.har.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.har.hibernet.entity.Employee;
import com.har.hibernet.util.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	System.out.println("mtlm");
    	SessionFactory factory = HibernateUtility.buildSessionFactory();
    	Session session = factory.openSession();
    	Employee e = new Employee(107, "L.L.D.B.", 65200, 10);
    	Transaction trans = session.beginTransaction();
    	session.save(e);
    	trans.commit();
    	factory.close();
    	
    	//HibernateUtility.shutDown();
    	
    }
}
