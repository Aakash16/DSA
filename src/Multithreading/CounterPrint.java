package Multithreading;

public class CounterPrint {

	public static void main(String[] args) {

		PrintEven thread1 = new PrintEven();
		PrintOdd thread2 = new PrintOdd();

		thread2.setThread(thread1);
		thread1.setThread(thread2);

		thread1.start();
		thread2.start();

	}

}

class PrintOdd extends Thread {

	int counter = -1;
	PrintEven e_thread;

	public PrintOdd() {
		counter = 1;

	}

	public void setThread(PrintEven thread) {
		e_thread = thread;
	}

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + (counter += 2));

			try {
				e_thread.wait();
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
		}
	}
}

class PrintEven extends Thread {

	int counter = -1;
	PrintOdd o_thread;

	public PrintEven() {
		counter = 2;
	}

	public void setThread(PrintOdd thread) {
		o_thread = thread;
	}

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 100; i++) {

			try {
				o_thread.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(getName() + " " + (counter += 2));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
		}
	}
}
