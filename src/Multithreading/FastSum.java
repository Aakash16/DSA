package Multithreading;

public class FastSum {

	static int N = 100;
	static int[] arr = new int[N];

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < N; i++) {
			arr[i] = (i + 1);
		}

		SumThread[] tArr = new SumThread[4];
		int[] start = new int[] { 0, (N / 4), (N / 2) , 3 * N / 4 };
		int[] end = new int[] { N / 4, N / 2, 3 * N / 4, N };

		long total = 0;
		long st = System.currentTimeMillis();

		for (int i = 0; i < 4; i++) {
			tArr[i] = new SumThread(start[i], end[i]);
			tArr[i].setName("Thread_" + (i + 1));

			tArr[i].start();

		}

		for (int i = 0; i < 4; i++) {
			tArr[i].join();
			long sm = tArr[i].getSum();
			total += sm;
		}

		/*
		 * for(int x:arr) { total += x; }
		 */

		System.out.println("Total: " + total + " " + (System.currentTimeMillis() - st));
	}

	static class SumThread extends Thread {

		int s, e;
		long sum;

		public SumThread() {

		}

		public SumThread(int i, int j) {
			s = i;
			e = j;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

			for (int i = s; i < e; i++) {
				sum += arr[i];
			}

			System.out.println("Sum sub by thread " + getName() + " " + sum);
		}

		public long getSum() {
			return sum;
		}
	}
}
