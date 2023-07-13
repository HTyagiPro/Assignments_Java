package PolyDemo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = null;
		int noR=0, noC=0, noT=0;
		for(int i = 0; i<10; i++)
			{
			if(s instanceof Circle)
				noC++;
			else if(s instanceof Rectangle)
				noR++;
			else
				noT++;
			s = ShapesFactory.produceShapes();
			System.out.println(s.area());
			System.out.print("  "+s.getClass().getName());
			}
	}

}
