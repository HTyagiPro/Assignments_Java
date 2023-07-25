package com.har.printModel;

public class Printer {
	public static void main(String[] args) {
		Printer1 printr = new Printer1();
		ChildThread ct1 = new ChildThread(printr,new String[] {"Hello", "welcome", "Bye-bye"});
		ChildThread ct2 = new ChildThread(printr,new String[] {"Apple", "Banana", "Cheeko"});
		ChildThread ct3 = new ChildThread(printr,new String[] {"Java", ".Net", "Python"});
		
		try {
			ct3.t.setPriority(8);
			ct1.t.join();
			ct2.t.join();
			ct3.t.join();
		}catch(InterruptedException e) {
			System.out.println(e);
		}
	System.out.println("Main terminated!!!");
	}
}



class Printer1 {
	synchronized void printMsg(String[] messages) {
		for(String m: messages)
			System.out.print(m+" ");
		System.out.println();
	}
}


class ChildThread implements Runnable{
	Thread t;
	Printer1 p;
	String[] messages;
	public ChildThread(Printer1 p, String[] messages) {
		t = new Thread(this);
		this.p = p;
		this.messages = messages;
		t.start();	
	}
	
	public void run() {
		p.printMsg(messages);
	}	
}


