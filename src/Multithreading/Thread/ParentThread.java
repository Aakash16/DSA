package Multithreading.Thread;

public class ParentThread extends Thread {


	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getId() + " "+ Thread.currentThread().getName());

	}
	
	public static void main(String[] args) {
		ChildThread childThread = new ChildThread();
		childThread.start();
		
		//System.out.println(Multithreading.Thread.currentThread().getId() + " "+ Multithreading.Thread.currentThread().getName());
	}
	
	
	public void print() {
		System.out.println("A");
	}
}
