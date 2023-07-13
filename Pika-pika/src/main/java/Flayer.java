interface Flyer {
	public void  fly();
}

class Man {
	String name;
	int age;
	String address;
	
	public Man(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void walk() {
		System.out.println("Walking");
	}
	
	public void eat() {
		System.out.println("Eating");
	}
}


class SuperMan extends Man implements Flyer{
	int krypLevel;
	
	public SuperMan(String name, int age, String address, int krypLevel) {
		super(name, age, address);
		this.krypLevel = krypLevel;
	}


	public void fly() {
		System.out.println("Superman Flying");
	}
}

class SpiderMan extends Man implements Flyer{
	
	int webLevel;
	
	public SpiderMan(String name, int age, String address, int webLevel) {
		super(name, age, address);
		this.webLevel = webLevel;
	}

	public void fly() {
		System.out.println("Spiderman Flying with Web");
	}
	
	public void web() {
		System.out.println("Shoot Web.");
	}
}

class Batman extends Man implements Flyer{
	
	int weapen;
	
	
	
	public Batman(String name, int age, String address, int weapen) {
		super(name, age, address);
		this.weapen = weapen;
	}

	public void fly() {
		System.out.println("Superman Flying");
	}
	
	public void drive() {
		System.out.println("Driving Batmobil");
	}
}

public class Flayer{
	public static void main(String[] args) {
		SpiderMan s = new SpiderMan("Peter Paker",26, "New York", 73);
		s.fly();
		s.web();
		s.walk();
		
		System.out.println(s);
	}
}
