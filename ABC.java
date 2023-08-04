
public class ABC {
	public static void main(String[] args) {
		String s = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
		int count =0;
		List<String> st1 = new List<String>(s.split(" "));
		
		for(int i =0; i<s.split(" ").length; i++) {
			count++;
			if (count==11) {
				st1.addAtPosition("\n", i);
				count=0;
			}
			
		}
		String fs ="";
		for(String p:st1.a)
			fs += " "+p;
			
		System.out.println(fs);
		
	}
}
