import java.time.LocalDate;

class TypeSafetyDemo<T>{
	T obj;

	public TypeSafetyDemo(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}

class TypeSafetyDemo2<Tp,Tu>{
	Tp obj;
	Tu obj2;
	public TypeSafetyDemo2(Tp obj, Tu obj2) {
		this.obj = obj;
		this.obj2 = obj2;
	}
	public Tp getObj() {
		return obj;
	}
	public void setObj(Tp obj) {
		this.obj = obj;
	}
	public Tu getObj2() {
		return obj2;
	}
	public void setObj2(Tu obj2) {
		this.obj2 = obj2;
	}

		
}


class TypeSafetyDemo3{
	public <Tp2> void printArray(Tp2[] a) {
		for(int i = 0 ; i<a.length;i++)
			System.out.println(a[i]);
	}
}


class TypeSafetyDemo4{
	
	public static <T extends Number> double getAverage(T[] a) {
		double sum =0;
		for(int i=0; i<a.length;i++)
			sum += a[i].doubleValue();
		return sum/a.length;
	}
}


class TypeSafetyDemo5<T extends Number>{
	T[] a;
	

	public TypeSafetyDemo5(T[] a) {
		this.a = a;
	}


	public double getAverage() {
		double sum =0;
		for(int i=0; i<a.length;i++)
			sum += a[i].doubleValue();
		return sum/a.length;
	}
	
	public boolean compAvg(TypeSafetyDemo5<?> ts) {
		return this.getAverage() == ts.getAverage();
	}


}


public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Integer  iobj = new Integer(10); 		//boxing
		int x = 20;
		
		Integer iobj1 = 50;						//auto-boxing
		
		Integer iobj2 = new Integer(x);			//boxing
		
		Integer iobj3 = Integer.valueOf(x);		//boxing
		
		String s = "500";
		int s1 = Integer.parseInt(s);
		System.out.println(s1+100);
		
		int a = iobj.intValue();
		float b = iobj2.floatValue();
		int c = iobj3.intValue();
		
		System.out.println(a+"    " + b + "    "+ c+"   "+iobj1);
		*/
		
		/*
		TypeSafetyDemo<Integer> ts1 = new TypeSafetyDemo<Integer>(new Integer(10));
		System.out.println(ts1.getObj());
		TypeSafetyDemo<String> ts2 = new TypeSafetyDemo<String>(new String("Hello World"));
		System.out.println(ts2.getObj());
		*/
		
		/*
		TypeSafetyDemo2<String, Generic_Employee> tps2 = new TypeSafetyDemo2<String, Generic_Employee>("Marketing", new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
		
		System.out.println(tps2.getObj()+"\t"+tps2.getObj2());
		*/
		
		/*
		Integer[] j = {10,20,30,40,50};
		String[] st = {"I", "Am", "Here"};
		TypeSafetyDemo3 ts3 = new TypeSafetyDemo3();
		ts3.printArray(j);
		ts3.printArray(st);
		ts3.printArray(new Generic_Employee[] {new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30))});
		*/
		
		
		//System.out.println(TypeSafetyDemo4.getAverage( new Integer[]{10,20,30,40,50}));
		
		TypeSafetyDemo5<Integer> ts5 = new TypeSafetyDemo5<Integer>(new Integer[]{10,20,30,40,50});
		
		TypeSafetyDemo5<Double> ts4 = new TypeSafetyDemo5<Double>(new Double[]{10.25,20.36,30.95,40.69,50.50});
		
		System.out.println(ts5.compAvg(ts4));
	}

}
