package HackerrankSI.sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();

			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {

				int num = sc.nextInt();
				arr[j] = num;
				
			}
			
			bubbleS(arr);

		}
		sc.close();
	}

	public static void bubbleS(int[] arr) {

		int n = arr.length;
		int c = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					c++;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		}
		
		
		System.out.println(c);
	}

}
