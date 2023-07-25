
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Generic_Employee> alist = new LinkedList<>();
		alist.add(new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
		alist.add(new Generic_Employee(102, 62500, "Vijay Saxena", LocalDate.of(2002, 1, 28)));
		alist.add(new Generic_Employee(103, 62500, "Digvijay Saxena", LocalDate.of(2002, 1, 29)));
		alist.add(new Generic_Employee(104, 62500, "Sanjay Saxena", LocalDate.of(2002, 1, 31)));
		
		LinkedList<Generic_Employee> alist2 = new LinkedList<>();
		
		
		
		/*
		ListIterator<String> itr =  alist.listIterator();
		while(itr.hasNext())
			System.out.print("\t"+itr.next());
		System.out.println("\n");
		
		*/
		
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
		
		/*
		System.out.println("List2: ");
		for(Generic_Employee i: alist2) {
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







