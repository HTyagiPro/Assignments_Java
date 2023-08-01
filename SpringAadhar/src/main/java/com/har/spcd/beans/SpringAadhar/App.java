package com.har.spcd.beans.SpringAadhar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.har.spcd.beans.AppConfig.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class); 
        
    	//ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
    	
    	Citizen c = container.getBean(Citizen.class);
        System.out.println(c);
        container.close();
    }
}
