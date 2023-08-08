package com.har.bootDemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.har.bootDemo.BootDemoApplication;
import com.har.bootDemo.beans.Department;
import com.har.bootDemo.repository.DepartmentRepository;

@Service
public class DepartmentServeice {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department getDepartmentByDepartmentId(int departmentId) {
		//ConfigurableApplicationContext container = SpringApplication.run(BootDemoApplication.class);	
		//DepartmentRepository departmentRepository = container.getBean(DepartmentRepository.class);
		
		Optional<Department> od = departmentRepository.findById(departmentId);
		if(od.isPresent()) return od.get();
		throw new RuntimeException();
	}
}
