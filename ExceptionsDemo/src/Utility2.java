import java.sql.SQLDataException;

public class Utility2 {
	
	public static int  divide2 (int x , int y) throws SQLDataException  {
		if (y!=0)
			return x/y;
		throw new java.sql.SQLDataException();
	
	}	
	
	
	class A{
		
	}
	class B extends A{
		
	}
	class C extends B{
		
	}
	
	
	
	
	
	/*
	
	public static void a() {
		throw new ArithmeticException();
		
	}
	public static void b() {
		a();
		
	}public static void c() {
		b();
		
	}
	public static void d() {
		c();
		
	}
	*/
}
