
public class Utility {
	public static void  divide(int x , int y) {
		try {
			System.out.println(x/y); 
		}
		catch(Exception e){
			throw e;
		
		}
	}
	
	public static int  divide2(int x , int y) {
		if (y!=0)
			return x/y;
		throw new ArithmeticException("Can't divide by zero.");
	
	}	
}
