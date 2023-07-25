import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Generic_Employee> alist = new HashSet<>();
		
		alist.add(new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
		alist.add(new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2002, 1, 28)));
		alist.add(new Generic_Employee(103, 62500, "Digvijay Saxena", LocalDate.of(2002, 1, 29)));
		alist.add(new Generic_Employee(104, 62500, "Sanjay Saxena", LocalDate.of(2002, 1, 31)));
		//System.out.println(alist.add(new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2002, 1, 28))));
		
		Object obj = new Object();
		
		/*
		HashSet<String> alist2 = new HashSet<>();
		alist2.add("Apple");
		alist2.add("Banana");
		alist2.add("Pineapple");
		alist2.add("Apple");
		alist2.add("Lemmon");
		alist2.add("null");
		alist2.add(null);
		*/
		
		
		/*
		ListIterator<String> itr =  alist.listIterator();
		while(itr.hasNext())
			System.out.print("\t"+itr.next());
		System.out.println("\n");
		
		*/
		/*
		System.out.println("List1: ");
		for(Generic_Employee i: alist) {
			System.out.print("\t" +i);
		}
		System.out.println("\n");
		System.out.println(alist.remove(new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2002, 1, 28))));
		System.out.println(alist.contains(new Generic_Employee(103, 62500, "Digvijay Saxena", LocalDate.of(2002, 1, 29))));
		System.out.println("List1: ");
		for(Generic_Employee i: alist) {
			System.out.print("\t" +i);
		}
		*/
		
		TreeSet<Generic_Employee> set = new TreeSet<>( new EmployeeSalaryComparator());
		/*set.add(new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
		set.add(new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2002, 1, 28)));
		set.add(new Generic_Employee(103, 62500, "Digvijay Saxena", LocalDate.of(2002, 1, 29)));
		*/
		Generic_Employee e1 = new Generic_Employee(104, 63500.15, "Ajay Saxena", LocalDate.of(2002, 1, 30));
		Generic_Employee e2 = new Generic_Employee(101, 62400, "Vjay Saxena", LocalDate.of(2002, 1, 30));
		Generic_Employee e3 = new Generic_Employee(102, 61700, "Sanjay Saxena", LocalDate.of(2002, 1, 30));
		Generic_Employee e4 = new Generic_Employee(103, 63500.10, "Digvjay Saxena", LocalDate.of(2002, 1, 30));
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
		//System.out.println(e1.compareTo(e2));
		
		
		/*
		set.add(10);
		set.add(20);
		set.add(50);
		set.add(40);
		set.add(30);
		set.add(60);
		*/
		
		Iterator itr = set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		
		/*
		System.out.println("List2: ");
		for(String i: alist2) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		*/
		
		/*
		System.out.println("Size: "+ alist.size());
		System.out.println("If contains: "+ alist.contains(0));
		System.out.println("Element at index 3: " + alist.get(3));
		*/
		
		
		
		//alist.remove(3);
		//System.out.println(alist.remove("103"));
		//alist.clear();
		
		/*
		System.out.println("List1: ");
		for(Generic_Employee i: alist) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		
		
		
		System.out.println("List2: ");
		for(Generic_Employee i: alist2) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		
		*/
		
	}

}








