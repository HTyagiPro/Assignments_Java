package com.har.hibernet.entity;
import javax.persistence.*;
import java.util.List;


@Entity
public class Courses {
	@Id
	private String course_name;
	private String course_dur;
	private String course_fee;
	private String course_faculty;
	
	
	@ManyToMany
	@JoinTable(name="std_course_reg", joinColumns = {@JoinColumn(name="course_name")}, inverseJoinColumns = {@JoinColumn(name="std_id")})
	List<Student> student;
	


	public Courses() {
	}


	public Courses(String course_name, String course_dur, String course_fee, String course_faculty) {
		this.course_name = course_name;
		this.course_dur = course_dur;
		this.course_fee = course_fee;
		this.course_faculty = course_faculty;
	}


	public Courses(String course_name, String course_dur, String course_fee, String course_faculty,
			List<Student> student) {
		this.course_name = course_name;
		this.course_dur = course_dur;
		this.course_fee = course_fee;
		this.course_faculty = course_faculty;
		this.student = student;
	}

	

	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getCourse_dur() {
		return course_dur;
	}


	public void setCourse_dur(String course_dur) {
		this.course_dur = course_dur;
	}


	public String getCourse_fee() {
		return course_fee;
	}


	public void setCourse_fee(String course_fee) {
		this.course_fee = course_fee;
	}


	public String getCourse_faculty() {
		return course_faculty;
	}


	public void setCourse_faculty(String course_faculty) {
		this.course_faculty = course_faculty;
	}

	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Courses:-\n----------------------------\nCourse Name: " + course_name + "\nCourse Duration: " + course_dur + "\nCourse Fee: " + course_fee
				+ "\nCourse_faculty: " + course_faculty + "\n----------------------------\n";
	}
	
	
}
