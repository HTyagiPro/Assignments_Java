import java.time.LocalDate;

class Stack1<T>{
	public T[] stack;
	int toS;
	
	Stack1(T[] stack){
		this.stack = stack;
		this.toS = -1;
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
	
}


//public class SubGenStack<T> extends Stack1<T>

public class SubGenStack<T> extends Stack1<Double>{
	SubGenStack(Double[] stack) {
		super(stack);
		// TODO Auto-generated constructor stub
	}

	/*
	SubGenStack(T[] stack) {
		super(stack);
		// TODO Auto-generated constructor stub
	}
*/
	public void push(Double ele) {
		if(!this.isFull()) {
			this.toS++;
			this.stack[this.toS] = ele;
			
		}else
			System.out.println("Stack OverFlow!!!");
	}
	
	
	/*
	public void push(T ele) {
		if(!this.isFull()) {
			this.toS++;
			this.stack[this.toS] = ele;
			
		}else
			System.out.println("Stack OverFlow!!!");
	}
	
	*/
	
	
	public void pop() {
		if(!this.isEmpty()) {
			System.out.println(this.stack[this.toS]);
			this.toS--;
		}else
			System.out.println("Stack Underflow!!!");
	}
	
	
	public static void main(String[] args) {
		
		SubGenStack<Double> s1 = new SubGenStack<Double>(new Double[10]);
		
			System.out.println(s1.isEmpty());
			System.out.println(s1.isFull());
			s1.push(0.0);
			s1.push(9.25);
			s1.push(6.458);
			s1.push(11.99);
			s1.pop();
			s1.pop();
			s1.pop();
			s1.pop();
			s1.pop();
			System.out.println(s1.toS);
			/*
			SubGenStack<String> s2 = new SubGenStack<String>(new String[10]);
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
		/*	
		SubGenStack<Generic_Employee> gemp = new SubGenStack<Generic_Employee>(new Generic_Employee[10]);
			gemp.push(new Generic_Employee(101, 62500, "Ajay Saxena", LocalDate.of(2002, 1, 30)));
			gemp.push(new Generic_Employee(102, 62500, "Ajay Saxena", LocalDate.of(2003, 2, 22)));
			gemp.push(new Generic_Employee(103, 62500, "Ajay Saxena", LocalDate.of(2004, 3, 30)));
			gemp.push(new Generic_Employee(104, 62500, "Ajay Saxena", LocalDate.of(2005, 4, 30)));
			gemp.pop();
		*/
		}
}
