package HackerrankSI.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ImpMinlHeap {

	private static int N = 1000000;
	private static int[] arr = new int[N];

	private static final String INS = "insert";
	private static final String MIN = "getMin";
	private static final String DEL = "delMin";
	
	private static int size; // Number of elements in heap
	private static Integer[] heap; // The heap array

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] sub = br.readLine().trim().split("\\s+");

			String opr = sub[0];

			switch (opr) {

			case INS:
				break;

			case MIN:

				break;

			case DEL:
				break;
			}
		}

		out.flush();
		br.close();
		out.close();
	}
	
	public static void insert(Integer x) {
		
		// Insert a new item to the end of the array
		int pos = ++size;

		// Percolate up
		for (; pos > 1 && x.compareTo(heap[pos / 2]) < 0; pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;
	}

}
