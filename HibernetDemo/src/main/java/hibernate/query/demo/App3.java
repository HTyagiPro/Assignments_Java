package hibernate.query.demo;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.har.hibernet.entity.Address2;
import com.har.hibernet.util.HibernateUtility;

public class App3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.buildSessionFactory();
		Session session = factory.openSession();
		
		
		//Query<Address2> qry = session.createQuery("from Address2",Address2.class);
		
		//Query<Address2> qry = session.createNamedQuery("getAllAddress",Address2.class);
		
		/*
		List<Address2> alist = qry.getResultList();
		
		for(Address2 a:alist)
			System.out.println(a);
		*/
		
		Criteria crt = session.createCriteria(Address2.class);
		crt.addOrder(Order.desc("add_city"));
		List<Address2> alist = crt.list();
		
		for(Address2 a:alist)
			System.out.println(a);
		
		session.close();
		
		
		
	}

}
