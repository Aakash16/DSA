package HackerrankSI.sorting;

import java.util.Scanner;

public class InsertionAdHoc {

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

			arr = insertionSort(arr);

		}
		sc.close();
	}

	public static int[] insertionSort(int[] arr) {

		final int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int max = Integer.MIN_VALUE;
			int idx = -1;
			for (int j = 0; j < (arr.length - i); j++) {
				if (arr[j] > max) {
					max = arr[j];
					idx = j;
				}
			}

			System.out.print(idx + " ");
			int temp = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = arr[idx];
			arr[idx] = temp;

		}

		return arr;
	}
}
