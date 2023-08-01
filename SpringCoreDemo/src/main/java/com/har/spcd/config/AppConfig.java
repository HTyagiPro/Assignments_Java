package com.har.spcd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.har.spcd.beans.Address;
import com.har.spcd.beans.Person;

@Configuration
@ComponentScan(basePackages ="com.har.spcd.beans" )
public class AppConfig {
	/*
	@Bean
	@Scope(scopeName = "prototype")
	public Address address() {
		return new Address(5,"SW Road", "Ghaziabad", "UP");
	}
	
	@Bean()
	public Person person() {
		Person p = new Person();
		p.setSsn(423);
		p.setName("Vijay");
		p.setAge(15);
		return p;
	}
*/
}
