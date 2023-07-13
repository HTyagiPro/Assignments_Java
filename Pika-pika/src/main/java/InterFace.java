interface Shape{
	double area();
}

class Circle{
	double r;
	public Circle(double r) {
		this.r = r;
	}
	public double area() {
		return 3.14*this.r*this.r;
	}
	
	public double parameter() {
		return 2*3.14*this.r;
	}
}


class Sphere extends Circle implements Shape{
	
	public Sphere(double r) {
		super(r);
	}
	public double area() {
		return (3/4) * 3.14*this.r*this.r;
		
	}
	
}





interface First
{
	double Pi = 3.14; 		//by default methods and variables are public static final
	
	int sum(int x, int y);
	
}

interface Second 
{
	double Pi = 3.14; 		//by default they are public static final
	
	int power(int x, int y);
}


interface Third extends Second
{
	double Pi = 3.14; 		//by default they are public static final
	
	int sq(int x);
	
}



class FirstImp implements Third{
	public int sum(int x, int y)
	{
		return x+y;
	}
	public int sq(int x)
	{
		return x*x;
	}
	
	public int power(int x, int n){
		int res = 1;
		for (;n>0;n--)
			res *= x;
		return res;
	}
}
	

class SecondImp implements Utility{
	public int sum(int x, int y)
	{
		return x-(-y);
	}
	
	
}
	
	
	
	

class InterFace{
	public static void main(String[] args){
		/*
		FirstImp f1 = new FirstImp(); //FirstImp();
		//System.out.println(f1.Pi);
		System.out.println(f1.sum(23,36));
		System.out.println(f1.sq(35));
		System.out.println(f1.power(10,3));
		*/
		
		/*
		Sphere s = new Sphere(4.0);
		System.out.println(s.area());
		*/
		/*
		SecondImp s = new SecondImp();
		System.out.println(s.sq(15));
		*/
		
		
		
		
	}
}
