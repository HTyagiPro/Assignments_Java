package finalDemo;

class Parent{
	 public int sum(int x, int y) {
		return x+y;
		
	}
}

class Child extends Parent{
	public int sum(int x, int y) {
		return x-(-y);
		
	}
}

public class TestFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
