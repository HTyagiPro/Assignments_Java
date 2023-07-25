


class Threas2 implements Runnable{
	Thread t;
	int priority;
	boolean flag = true;
	volatile long x = 0L;
	
	
	public Threas2(String name, int priority) {
		t = new Thread(this, name);
		t.setPriority(priority);
		t.start();
		
	}

	public void run() {
		while(flag) {
			x++;
		}
		System.out.println(t.getName()+" Died!!!");
		
		/*
		try {
		for(int i=20;i<30; i++) {
			System.out.println(t.getName()+i);
			t.sleep(1000);
		}
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		System.out.println(t.getName()+" Died!!!");
		*/
	}
	
	
	public void stop() {
		flag = false;
	}
	
	
}









public class ThreadDemo1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Threas2 hp = new Threas2("HP Thread.", 10);
		Threas2 lp = new Threas2("LP Thread.", 3);
		try {
		
		Thread.sleep(3000);
		
		hp.stop();
		lp.stop();
		
		hp.t.join();	
		lp.t.join();
			
			for(int i=10;i<20; i++)
				System.out.println("First"+i);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Hp ececuted: "+hp.x);
		System.out.println("Lp ececuted: "+lp.x );
		System.out.println("Main terminated!!!");
	}


}




/*
class Thread2 extends Thread{
	Thread t2;
	public Thread2() {
		start();
	}
	
	
	public void run() {
		for(int i=10;i<2100; i++)
			System.out.println("Second"+i);
	}
	
}









public class ThreadDemo1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread2 th2 = new Thread2();
			
		
			for(int i=1000;i<2000; i++)
				System.out.println("First"+i);
			
			
	}
}
*/



//Alternate method
/*
class Threas2 implements Runnable{
	
	public void run() {
		for(int i=10;i<2100; i++)
			System.out.println("Second"+i);
	}
	
}









public class ThreadDemo1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread th2 = new Thread(new Threas2());
		System.out.println(th2.MIN_PRIORITY);
		
			for(int i=1000;i<2000; i++)
				System.out.println("First"+i);
			
			
	}

}
*/