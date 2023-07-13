import graphics.Rectangle;
import graphics.Circle;
import static graphics.Calc.*;
class Test{
	public static void main(String[] args) 
	{
		Rectangle r1 = new Rectangle(10,15);
		System.out.println(r1.area());
		Circle c1 = new Circle(7);
		System.out.println(c1.area());
		System.out.println(Pi);
		System.out.println(power(5, 3));
		System.out.println(sum(67, 97));
		
	}
}