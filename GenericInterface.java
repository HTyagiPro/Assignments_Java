import java.time.LocalDate;

interface GenDemo<T>{
	void printArray(T[] a);
}

public class GenericInterface<T> implements GenDemo<T>{
	public void printArray(T[] a) {
		for (int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		Generic_Employee[] err = {	new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)),
									new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2001, 1, 30)),
									new Generic_Employee(103, 62500, "Sanjay Saxena", LocalDate.of(2002, 1, 30))};
		GenericInterface<Generic_Employee> gif = new GenericInterface<Generic_Employee>();
		gif.printArray(err);
	}
}
