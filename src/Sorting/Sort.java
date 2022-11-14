package Sorting;

import java.util.Arrays;

public class Sort {

	static int[] arr;

	public Sort(int[] arr) {
		this.arr = arr;
	}

	public static int[] bubbleSort() {

		System.out.println("Old array: " + Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			final int min = arr[i];
			System.out.print("min: " + min + " ");
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (min < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			System.out.println("\tloop: " + i + " " + Arrays.toString(arr));
		}

		return arr;

	}

	public static void bubbleS() {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	public static int[] insertionSort() {

		final int len = arr.length;
		for (int i = 0; i < len; i++) {

			int min_idx = i;

			for (int j = i + 1; i < len; i++) {

				print("loop " + i);
				if (arr[min_idx] < arr[j]) {
					min_idx = j;
				}

				int temp = arr[i];
				arr[i] = arr[min_idx];
				arr[min_idx] = temp;
			}
		}

		// print();
		return arr;
	}

	public static int[] insSort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}

	public static void print(String msg) {
		System.out.println(msg + " " + Arrays.toString(arr));

	}
}
