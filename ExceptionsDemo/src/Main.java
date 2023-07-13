import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		System.out.print("Enter first number: ");
		int a = scan.nextInt();
		
		System.out.print("Enter second number: ");
		int b = scan.nextInt();
		*/
		
		int x = 10, y=5
				;
		int[] ar = {10,20,30,40};
		
		try {
			
			
			System.out.println(x/y);
			System.out.println(ar[y]);
		}catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e);
		}
		
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	
		
		
		/*
		try {
		Utility2.divide2(a,b);
		
		
		}
		catch (Exception e) {	
			System.out.println(e);
			System.out.println("In main");
		}
		finally {
			System.out.println("I am finally block");
		}
		
		System.out.println("End");
		*/
		
		
		scan.close();
	}
	
	public void sub() {}
}
