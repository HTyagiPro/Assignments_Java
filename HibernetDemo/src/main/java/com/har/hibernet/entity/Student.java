package com.har.hibernet.entity;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "Students")
public class Student {
	@Id
	private int std_id;
	private String std_name;
	private String std_mob;
	private String std_add;
	
	
	@ManyToMany(mappedBy = "student")
	private List<Courses> courses;
	

	public Student() {
	}

	

	
	public Student(int std_id, String std_name, String std_mob, String std_add, List<Courses> courses) {
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_mob = std_mob;
		this.std_add = std_add;
		this.courses = courses;
	}


	public int getStd_id() {
		return std_id;
	}



	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}





	public String getStd_name() {
		return std_name;
	}





	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}





	public String getStd_mob() {
		return std_mob;
	}





	public void setStd_mob(String std_mob) {
		this.std_mob = std_mob;
	}





	public String getStd_add() {
		return std_add;
	}





	public void setStd_add(String std_add) {
		this.std_add = std_add;
	}







	public List<Courses> getCourses() {
		return courses;
	}


	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Student:-\n---------------------------------\nStudent Id: " + std_id + "\nStudent Name: " + std_name + "\nStudent Mob.: " + std_mob + "\nStudent Add.: " + std_add
				+ "\n---------------------------------\n";
	}
	
	
	
}
