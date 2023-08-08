package com.har.bootDemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.har.bootDemo.beans.Book;
import com.har.bootDemo.beans.Department;
import com.har.bootDemo.beans.Employee;
import com.har.bootDemo.beans.Person;
import com.har.bootDemo.repository.BookRepository;
import com.har.bootDemo.repository.DepartmentRepository;
import com.har.bootDemo.service.DepartmentServeice;

@SpringBootApplication
public class BootDemoApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(BootDemoApplication.class, args);
		//BookRepository bookRepository = container.getBean(BookRepository.class);
		//System.out.println("Hello from Spring Boot Application");
		
		/*
		Person p = container.getBean(Person.class);
		Employee e = container.getBean(Employee.class);
		System.out.println(p);
		System.out.println(e);
		*/
		//bookRepository.deleteById("JRC101");
		
		/*
		Book bk = new Book("JRC101", "God's Eye", "Harvey Spector", "Law Book", 1500, 8);
		bookRepository.save(bk);
		*/
		
		/*
		Optional<Book> bk = bookRepository.findById("JRC103");
		if (bk.isPresent()) {
			Book b1 = bk.get();
			System.out.println(b1);
		}else System.out.println("Book with given ID does't exist!!");
		
		*/
		
		/*
		List<Book> books = bookRepository.findAll();
		for(Book b : books)
			System.out.println(b);
		*/
		
		//System.out.println(bookRepository.findBookByBook_title("God's Eye1").get());
		
		/*
		DepartmentRepository departmentRepository = container.getBean(DepartmentRepository.class);
		Optional<Department> d = departmentRepository.findById(10);
		
		if(d.isPresent()) {
			System.out.println(d.get());
			for (Employee e : d.get().getEmployees())
				System.out.println(e);
		}
		
		*/
		
		/*
		DepartmentServeice ds =container.getBean(DepartmentServeice.class);
		Department d1 = ds.getDepartmentByDepartmentId(40);
		System.out.println(d1);
		for(Employee e : d1.getEmployees())
			System.out.println(e);
		*/
		
	}

}

















