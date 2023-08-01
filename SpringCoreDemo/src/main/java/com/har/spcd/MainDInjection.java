package com.har.spcd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.har.spcd.beans.Country;
import com.har.spcd.beans.Person;
import com.har.spcd.config.AppConfig;

public class MainDInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		Person p = container.getBean(Person.class);
		System.out.println(p);
		
		
		/*
		Country c = container.getBean("ctry", Country.class);
		System.out.println(c);
		*/
		
		
	}

}
