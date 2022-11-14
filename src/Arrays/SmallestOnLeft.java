package Arrays;

import java.util.Stack;

//Java implementation of efficient algorithm to find 
// smaller element on left side 
class SmallestOnLeft {

// Prints smaller elements on left side of every element 
	static void printPrevSmaller(int arr[], int n) { 
		// Create an empty stack 
		Stack<Integer> S = new Stack<>(); 

		// Traverse all array elements 
		for (int i = 0; i < n; i++) { 
			// Keep removing top element from S while the top 
			// element is greater than or equal to arr[i] 
			while (!S.empty() && S.peek() >= arr[i]) { 
				S.pop(); 
			} 

			// If all elements in S were greater than arr[i] 
			if (S.empty()) { 
				System.out.print("_, "); 
			} else //Else print the nearest smaller element 
			{ 
				System.out.print(S.peek() + ", "); 
			} 

			// Push this element 
			S.push(arr[i]); 
		} 
	} 

	/* Driver program to test insertion sort */
	public static void main(String[] args) { 
		int arr[] = {6, 2 ,5 ,4, 5, 1 ,6}; 
		int n = arr.length; 
		printPrevSmaller(arr, n); 
	} 
} 
