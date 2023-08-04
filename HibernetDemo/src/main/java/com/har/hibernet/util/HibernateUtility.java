package com.har.hibernet.util;

import org.hibernate.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {
	
	public static SessionFactory buildSessionFactory(){

//		SessionFactory sessionFactory = null;
//		try {
//			if(sessionFactory == null) {
//				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//				
//				Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//				
//				sessionFactory = metadata.getSessionFactoryBuilder().build();
//				
//			}
//		}catch (Exception e) {
//			
//			System.out.println(e);
//		}
	
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
	
		return sessionFactory;
	
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}


	
	public static void shutDown() {
		if(buildSessionFactory()!=null)
		getSessionFactory().close();;
	}
	
}
