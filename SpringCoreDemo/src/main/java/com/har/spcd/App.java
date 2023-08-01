package com.har.spcd;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.har.spcd.beans.Vish;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
       
    	//FileSystemXmlApplicationContext container = new FileSystemXmlApplicationContext("C:\\Users\\HTyagi\\Desktop\\Pikachu\\NinjaHatori\\beans.xml");
    	
    	
    	/*
    	Vish v1 = container.getBean("vish1", Vish.class);
    	Vish v2 = container.getBean("vish1", Vish.class);
    	v2.setMessage("Welcome to Spring");
    	System.out.println(v1.getMessage() );
    	System.out.println(v2.getMessage() );
    	*/
    	container.close();
    }
}
