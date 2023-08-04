import java.time.LocalDate;

class Stack<T>{
	private T[] stack;
	int toS;
	
	Stack(T[] stack){
		this.stack = stack;
		this.toS = -1;
	}
	
	
	public void push(T ele) {
		if(!this.isFull()) {
			this.toS++;
			this.stack[this.toS] = ele;
			
		}else
			System.out.println("Stack OverFlow!!!");
	}
	
	public void pop() {
		if(!this.isEmpty()) {
			System.out.println(this.stack[this.toS]);
			this.toS--;
		}else
			System.out.println("Stack Underflow!!!");
	}
	
	public boolean isEmpty() {
		if (this.toS ==-1)
			return true;
		else 
			return false;
	}
	
	public boolean isFull() {
		if (stack.length == this.toS)
			return true;
		else 
			return false;
	}
	public static void main(String[] args) {
	/*	
	Stack<Integer> s1 = new Stack<Integer>(new Integer[10]);
		System.out.println(s1.isEmpty());
		System.out.println(s1.isFull());
		s1.push(0);
		s1.push(9);
		s1.push(6);
		s1.push(11);
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		System.out.println(s1.toS);
		Stack<String> s2 = new Stack<String>(new String[10]);
		s2.push("Hello");
		s2.push("World");
		s2.push("I");
		s2.push("Am");
		s2.push("Here");
		s2.push("How");
		s2.push("Are");
		s2.push("You");
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		System.out.println(s2.toS);
		*/
		
		Stack<Generic_Employee> gemp = new Stack<Generic_Employee>(new Generic_Employee[10]);
		gemp.push(new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
		gemp.push(new Generic_Employee(102, 62500, "Ajay Saxena", LocalDate.of(2003, 2, 22)));
		gemp.push(new Generic_Employee(103, 62500, "Ajay Saxena", LocalDate.of(2004, 3, 30)));
		gemp.push(new Generic_Employee(104, 62500, "Ajay Saxena", LocalDate.of(2005, 4, 30)));
		gemp.pop();
	}
}