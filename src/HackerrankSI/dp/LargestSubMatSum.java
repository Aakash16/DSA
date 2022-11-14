package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LargestSubMatSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");

			int n = Integer.parseInt(ints[0]);
			int m = Integer.parseInt(ints[1]);

			int[][] mat = new int[n][m];

			for (int i = 0; i < n; i++) {
				ints = br.readLine().trim().split("\\s+");
				for (int j = 0; j < m; j++) {
					mat[i][j] = Integer.parseInt(ints[j]);
				}
			}

			//colPrefixSum(mat);
			long ans = maxSumRect(n, m, mat);
			// print(mat);
			System.out.println(ans);
		}

		out.flush();
		br.close();
		out.close();
	}
	
	private static int kadane(int arr[], int start, int end, int n) {    //find max sum and starting and ending location
		   int sum = 0, maxSum = Integer.MIN_VALUE;

		   end = -1;    //at first no place is selected

		   int tempStart = 0;    //starting from 0

		   for (int i = 0; i < n; i++) {
		      sum += arr[i];
		      if (sum < 0) {
		         sum = 0;
		         tempStart = i+1;
		      }else if (sum > maxSum) {     //get maximum sum, and update start and end index
		         maxSum = sum;
		         start = tempStart;
		         end = i;
		      }
		   }

		   if (end != -1)
		      return maxSum;
		   //when all elements are negative in the array
		   maxSum = arr[0];
		   start = end = 0;

		   // Find the maximum element in array
		   for (int i = 1; i < n; i++) {
		      if (arr[i] > maxSum) {
		         maxSum = arr[i];
		         start = end = i;
		      }
		   }
		   return maxSum;
		}
	
	private static long maxSumRect(int n, int m, int[][] mat) {
		   long maxSum = Long.MIN_VALUE;
		   
		   //endLeft, endRight, endTop, endBottom;

		   int i, j;
		   int[] temp = new int[n];
		   int sum, start = 0, end = 0;

		   for (i = 0; i < m; i++) {
		      for(int k = 0; k<n; k++)//temp initially holds all 0
		         temp[k] = 0;

		      for (j = i; j < m; ++j) {
		         for (int k = 0; k < n; ++k)    //for each row, find the sum
		            temp[k] += mat[k][j];
		            sum = kadane(temp, start, end, n);    //find sum of rectangle (top, left) and (bottom right)

		         if (sum > maxSum) {    //find maximum value of sum, then update corner points
		            maxSum = sum;
					/*
					 * endLeft = left; endRight = right; endTop = start; endBottom = end;
					 */
		         }
		      }
		   }

		   return maxSum;
		}
	
	/*private static long getMaxSum(int[][] mat, int n, int m) {

		long ans = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int[] a = new int[m];
			
			for(int k = 0;k<m;k++)
				a[k] = mat[i][k];
			
			long sub = maxSubArraySum(a, i);
			
		}

		return ans;

	}

	private static long[] getRangeSumArr(int[][] mat, int s, int e) {

		long[] arr = new long[e - s];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i] += mat[i][j];
			}
		}
		return arr;
	}

	private static long getMaxSSum(long[] arr) {
		int size = arr.length;
		long max = Long.MIN_VALUE, max_end = 0;

		for (int i = 0; i < size; i++) {
			max_end = max_end + arr[i];
			if (max < max_end)
				max = max_end;
			if (max_end < 0)
				max_end = 0;
		}
		return max;
	}*/

	/*private static int[] getMaxSubArrSum(int[][] mat, int k) {
		int size = mat[0].length;
		int[] ans = new int[2];
		long max_so_far = Long.MIN_VALUE;
		int max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += mat[k][i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}

		System.out.println("max at " + start + " " + end);
		ans[0] = start;
		ans[1] = end;
		return ans;

	}

	static long maxSubArraySum(int a[], int k) {
		int size = a.length;

		System.out.println(Arrays.toString(a));
		long max_so_far = Long.MIN_VALUE;
		int max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}

		System.out.println("max at " + start + " " + end + " " + max_so_far);
		return (end - start + 1);
	}
	
	static int maxSubArraySum(long a[]) {
		int size = a.length;

		long max_so_far = Long.MIN_VALUE;
		int max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}

		System.out.println("max at " + start + " " + end + " " + max_so_far);
		return (end - start + 1);
	}*/

	private static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void colPrefixSum(int[][] mat) {

		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = mat[i][j] + mat[i - 1][j];

			}
		}
	}

}
