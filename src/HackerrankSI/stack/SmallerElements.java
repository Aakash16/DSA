package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class SmallerElements {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			long ans = countSmaller(ar);
			System.out.println(ans);
		}

		br.close();
		out.close();
	}

	static long countSmaller(int[] nums) {

		Num[] arr = new Num[nums.length];

		for (int i = 0; i < nums.length; i++) {
			arr[i] = new Num();
			arr[i].value = nums[i];
			arr[i].index = i;
		}

		Num[] temp = new Num[nums.length];

		mergeSort(arr, temp, 0, nums.length - 1);

		int[] ans_ar = new int[nums.length];
		long ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans_ar[arr[i].index] = arr[i].count;
			ans += ans_ar[arr[i].index];
		}

		return ans;
	}

	static class Num {
		int value;
		int index;
		int count;
	}

	static void mergeSort(Num[] nums, Num[] temp, int high, int low) {

		if (high >= low) {
			return;
		}

		int diff = low - high;
		int mid = diff / 2;
		int left = high + mid;
		int right = left + 1;

		mergeSort(nums, temp, high, left);
		mergeSort(nums, temp, right, low);
		merge(nums, temp, high, low);
	}

	static void merge(Num[] nums, Num[] temp, int left, int right) {
		int diff = right - left;
		int mid = diff / 2;
		int l_end = left + mid;
		int r_start = l_end + 1;

		// left half is sorted

		// right half is sorted

		// merge the two sorted arrays in nums into temp

		int l_idx = left;
		int r_idx = r_start;
		int temp_idx = left;

		while (l_idx <= l_end && r_idx <= right) {
			if (nums[l_idx].value <= nums[r_idx].value) {
				temp[temp_idx] = nums[l_idx];
				l_idx++;
				temp_idx++;
			} else {
				// right is smaller
				temp[temp_idx] = nums[r_idx];
				r_idx++;
				temp_idx++;
				// the right element is smaller
				// which means that all the elements in left are bigger
				for (int i = l_idx; i <= l_end; i++) {
					nums[i].count++;
				}
			}
		}

		while (l_idx <= l_end) {
			temp[temp_idx] = nums[l_idx];
			l_idx++;
			temp_idx++;
		}

		while (r_idx <= right) {
			temp[temp_idx] = nums[r_idx];
			r_idx++;
			temp_idx++;
		}

		// copy temp back to nums
		for (int i = left; i <= right; i++) {
			nums[i] = temp[i];
		}
	}

	void old(int[] ar, int len) {
		int[] P2 = new int[len];
		Stack<Integer> st = new Stack<Integer>();
		long ans = 0;
		for (int i = len - 1; i >= 0; i--) {

			while (!st.empty() && ar[i] <= ar[st.peek()]) {
				st.pop();
			}

			if (!st.empty()) {

				P2[i] = st.peek();
			}

			st.push(i);

		}
		System.out.println(Arrays.toString(P2));
		int idx = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (P2[i] > 0) {
				System.out.println("at: " + i);
				P2[i] = len - P2[i];
				idx = i;
				break;
			}
		}

		// 10 6 15 20 30 5 7

		for (int i = idx - 1; i >= 0; i--) {
			if (P2[i] > 0) {

				System.out.println("att: " + i + " " + P2[i] + " " + P2[P2[i] - 1]);
				P2[i] = P2[P2[i] - 1];
				ans = ans + P2[i];
			}
		}

		System.out.println(Arrays.toString(P2));

	}
}
