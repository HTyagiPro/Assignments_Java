interface GenIntf<T>{
	public void addFirst(T ele);
	public void append(T ele);
	public boolean searchElement(T ele);
}

class GenericStack<T> implements GenIntf<T>{
	private T[] stack;
	int toS;
	
	GenericStack(T[] stack){
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
	
	

	public void addFirst(T ele) {
		// TODO Auto-generated method stub
		if(this.eleLength() >=0 && this.eleLength() < this.stack.length) {
			this.shiftRight(0);
			this.stack[0] = ele;
		}else 
			throw new RuntimeException("No space to add element.");
		
	}
	
	
	
	public void append(T ele) {
		// TODO Auto-generated method stub
		if(!this.isFull()) {
			this.toS++;
			this.stack[this.toS] = ele;
			
		}else
			System.out.println("Stack OverFlow!!!");
	}
	
	
	public boolean searchElement(T ele) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.stack.length;i++)
			if(this.stack[i] == ele)
				return true;
		return false;
	}
	
	public void shiftRight(int p) {
		for(int j=this.eleLength() ; j>=p && j!= this.stack.length ; j-- ) {
			
			this.stack[j+1]=this.stack[j];
		}
	}
	
	public int eleLength() {
		int eLength = 0;
		while(this.stack[eLength] != null && eLength < this.stack.length) {
			eLength++;
			if(eLength == this.stack.length)
				break;
		}
			
		return eLength;
	}
	
}


class GenericStringStack<T> implements GenIntf<String>{
	private T[] stack;
	int toS;
	
	GenericStringStack(T[] stack){
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
	
	

	public void addFirst(String ele) {
		// TODO Auto-generated method stub
		if(this.eleLength() >=0 && this.eleLength() < this.stack.length) {
			this.shiftRight(0);
			this.stack[0] = (T) ele;
		}else 
			throw new RuntimeException("No space to add element.");
		
	}
	
	
	
	public void append(String ele) {
		// TODO Auto-generated method stub
		if(!this.isFull()) {
			this.toS++;
			this.stack[this.toS] = (T) ele;
			
		}else
			System.out.println("Stack OverFlow!!!");
	}
	
	
	public boolean searchElement(String ele) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.stack.length;i++)
			if(this.stack[i] == ele)
				return true;
		return false;
	}
	
	public void shiftRight(int p) {
		for(int j=this.eleLength() ; j>=p && j!= this.stack.length ; j-- ) {
			
			this.stack[j+1]=this.stack[j];
		}
	}
	
	public int eleLength() {
		int eLength = 0;
		while(this.stack[eLength] != null && eLength < this.stack.length) {
			eLength++;
			if(eLength == this.stack.length)
				break;
		}
			
		return eLength;
	}
	
}







public class GenStackInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<Integer> s1 = new GenericStack<Integer>(new Integer[10]);
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
		GenericStringStack<String> s2 = new GenericStringStack<String>(new String[10]);
		s2.push("Hello");
		s2.push("World");
		s2.push("I");
		s2.push("Am");
		s2.push("Here");
		s2.push("How");
		s2.push("Are");
		s2.push("You");
		s2.addFirst("hello");
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		System.out.println(s2.toS);
		
		

	}

}




