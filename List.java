
public class List {
	Object[] a;
	public int ptr=2;
	
	public List(Object[] a) {
		this.a = a;
	}
	
	

	public Object[] getA() {
		return a;
	}



	public void setA(Object[] a) {
		this.a = a;
	}



	public int getPtr() {
		return ptr;
	}



	public void setPtr(int ptr) {
		this.ptr = ptr;
	}
	
	
	

	public void shiftRight(int p) {
		for(int j=this.eleLength() ; j>=p && j!= this.a.length ; j-- ) {
			
			this.a[j+1]=this.a[j];
		}
	}
	
	public int eleLength() {
		int eLength = 0;
		while(this.a[eLength] != null && eLength < this.a.length) {
			eLength++;
			if(eLength == this.a.length)
				break;
		}
			
		return eLength;
	}
	
	

	//Delete element from beginning
	
	public void deleteAtBeg() {
		if(this.eleLength()>0) {
			for(int j=0 ; j< this.eleLength()-1 && j <this.a.length-1 ; j++ ) {
				this.a[j]=this.a[j+1];
			}
			this.a[this.eleLength()-1]= null;	
		}else
			throw new RuntimeException("No element to delete.");
	}
	
	
	//Delete element for index p
	
	public void deleteAtPosition(int p) {
		if(p == this.a.length-1) {
			this.deleteAtEnd();
		}else if(p == 0) {
			this.deleteAtBeg();
		}else {
			this.a[p] = null;
		}
	}
	
	
	//Delete element from for End
	
	public void deleteAtEnd() {
		if(this.eleLength()>0)
			this.a[this.eleLength()-1] = null;
		else
			throw new RuntimeException("No element to delete.");
	}
	
	//Delete selected element
	
	public boolean deleteElement(Object ele) throws RuntimeException {
		for(int k=0; k<this.eleLength();k++) {
			if(this.a[k] == ele) {
				this.a[k] = null;
				return true;
			}
		}
		throw new RuntimeException("\t Element not found!!");
	}
	
	
	//Add element in the beginning
	
	public void addAtTheBeg(Object ele)  throws RuntimeException{
		if(this.eleLength() >=0 && this.eleLength() < this.a.length) {
			this.shiftRight(0);
			this.a[0] = ele;
		}else 
			throw new RuntimeException("No space to add element.");
		
		
	}
	
	//Add element at the end
	
	public void addAtEnd(Object ele) throws RuntimeException {
		if(this.eleLength() >=0 && this.eleLength() < this.a.length)
			this.a[this.eleLength()] = ele;
		else 
			throw new RuntimeException("No space to add element.");
	}
	
	
	//Add element at index p
	
	public void addAtPosition(Object ele, int p) {
		this.shiftRight(p+1);
		this.a[p] = ele;
	}
	
	
	//Print list
	
	public void printList() {
		for(Object p:this.a){
			if(p!=null)
			System.out.print(p + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List l = new List(new Integer[10]);
		try {
		l.addAtTheBeg(9);
		l.printList();
		l.addAtTheBeg(8);
		l.printList();
		l.addAtTheBeg(7);
		l.printList();
		l.addAtEnd(10);
		l.printList();
		l.addAtEnd(30);
		l.printList();
		l.deleteAtEnd();
		l.printList();
		l.addAtEnd(40);
		l.printList();
		l.deleteAtBeg();
		l.printList();
		l.addAtTheBeg(7);
		l.printList();
		l.deleteAtPosition(2);
		l.printList();
		l.addAtPosition(99, 2);
		l.printList();
		l.deleteElement(3);
		l.printList();
		
		System.out.println(l.eleLength());
		}catch(RuntimeException re) {
			System.out.println(re);
		}
		System.out.println("Final List:-");
		 l.printList();
		
}
}
