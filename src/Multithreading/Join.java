package Multithreading;

public class Join extends Thread{
	
	Thread t;
	
	Join (Thread t){
		this.t = t;
	}
	public void run() {
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
		//s	System.out.println("child");
		}
		
	}

}
