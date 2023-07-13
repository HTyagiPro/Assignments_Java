package PolyDemo;

public class Triangle extends Shape {
	private double height;
	private double base;
	
	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}
	
	public double area() {
		return (0.5*height*base);
	}
	
	
	}
