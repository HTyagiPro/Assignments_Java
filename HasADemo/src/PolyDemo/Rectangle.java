package PolyDemo;

public class Rectangle extends Shape {
	private double len;
	
	private double breadth;
	

	public Rectangle(double len, double breadth) {
		this.len = len;
		this.breadth = breadth;
	}

	public double area() {
		return len*breadth;
	}
	
		
}
