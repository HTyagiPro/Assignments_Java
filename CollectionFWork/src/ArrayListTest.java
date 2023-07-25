import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> alist = new ArrayList<>();
		alist.add("100");
		alist.add("101");
		alist.add("102");
		alist.add("103");
		alist.add("103");
		ArrayList<String> alist2 = new ArrayList<>();
		alist2.add("103");
		alist2.add("108");
		alist2.add("109");
		alist2.add(2, "105");
		
		/*
		ListIterator<String> itr =  alist.listIterator();
		while(itr.hasNext())
			System.out.print("\t"+itr.next());
		System.out.println("\n");
		
		*/
		
		System.out.println("List1: ");
		for(String i: alist) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		System.out.println("List2: ");
		for(String i: alist2) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		
		alist.retainAll(alist2);
		System.out.println((alist.containsAll(alist2)));
		/*
		System.out.println("Size: "+ alist.size());
		System.out.println("If contains: "+ alist.contains(0));
		System.out.println("Element at index 3: " + alist.get(3));
		*/
		
		
		
		//alist.remove(3);
		//System.out.println(alist.remove("103"));
		//alist.clear();
		
		System.out.println("List1: ");
		for(String i: alist) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		
		
		
		System.out.println("List2: ");
		for(String i: alist2) {
			System.out.print("\t" + i);
		}
		System.out.println("\n");
		
		
		
	}

}


