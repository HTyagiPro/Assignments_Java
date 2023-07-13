package graphics;
public class Rectangle
{
	private double length, breadth;
	public Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	public double area(){
		return this.length*this.breadth;
	}
}