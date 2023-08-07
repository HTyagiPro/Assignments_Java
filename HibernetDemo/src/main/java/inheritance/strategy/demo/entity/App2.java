package inheritance.strategy.demo.entity;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.har.hibernet.util.HibernateUtility;


public class App2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		SalariedEmployee se = new SalariedEmployee(101,"Ajay", 15000);
		HourlyWagesEmployee hwe = new HourlyWagesEmployee(102, "Vijay", 50, 1200);
		
		session.save(se);
		session.save(hwe);
		
		trans.commit();
		
		session.close();
		HibernateUtility.shutDown();
		
		
	}

}
