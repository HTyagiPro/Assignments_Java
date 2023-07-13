package PolyDemo;

public class ShapesFactory {
	public static Shape produceShapes() {
		switch(new java.util.Random().nextInt()%3) {
		case 0:
			return new Circle(4.6);
		case 1: 
			return new Rectangle(6,8);
		default : 
			return new Triangle(12,5);
		}
	}
}
