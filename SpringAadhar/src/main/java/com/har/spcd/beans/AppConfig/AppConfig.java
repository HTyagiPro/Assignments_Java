package com.har.spcd.beans.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.har.spcd.beans.SpringAadhar.AadharCard;
import com.har.spcd.beans.SpringAadhar.Citizen;

@Configuration
@ComponentScan(basePackages ="com.har.spcd.beans.SpringAadhar" )
public class AppConfig {
	/*
	@Bean
	public AadharCard aadharCard() {
		return new AadharCard("511480849285");
	}
	
	@Bean
	public Citizen citizen() {
		return new Citizen("Ajay", 20, "HNo.5 SW Road, Noida, U.P.", aadharCard());
	}
	*/
}
