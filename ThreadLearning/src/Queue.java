class Queue1{
	int ele;
	boolean flag=false;
	
	synchronized public void read() {
		if(!flag) {
			System.out.println("Read   " +ele);
			flag = true;
			notify();
		}
		try {
			wait();
		}catch(InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	synchronized public void write(int ele) {
		if(flag) {
			this.ele = ele;
			System.out.println("Written: "+ele);
			flag = false;
			notify();
		}
		try {
			wait();
		}catch(InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
	}
}

class ReadThread implements Runnable{
	Thread t;
	Queue1 q;
	public ReadThread(Queue1 q) {
		t = new Thread(this);
		this.q = q;
		t.start();
	}
	public void run() {
		while(true)
			q.read();
	}
	
}


class WriteThread implements Runnable{
	Thread t;
	Queue1 q;
	
	public WriteThread(Queue1 q) {
		t = new Thread(this);
		this.q = q;
		t.start();
	}
	public void run() {
		int n = 1;
		while(true && n <500) {
			q.write(n++);
		}
		
	}
	
}




public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue1 que = new Queue1();
		 ReadThread rtd = new ReadThread(que);
		 WriteThread wtd = new WriteThread(que);
		 
		 try {
			 rtd.t.join();
			 wtd.t.join();
		 }catch(InterruptedException e) {
			 System.out.println(e);
		 }
		 
	}

}
