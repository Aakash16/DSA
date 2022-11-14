package Interviewbit.stack;

import java.util.Stack;

class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
	}

	Stack<Integer> st = new Stack<>();
	Stack<Integer> stm = new Stack<>();
	int min = Integer.MAX_VALUE;

	public void push(int x) {
		st.push(x);
		if (x < min) {
			stm.push(x);
		}

	}

	public void pop() {
		if (!st.isEmpty()) {
			int x = st.pop();

			if (!stm.isEmpty() && x == st.peek()) {
				stm.pop();
			}
		}
	}

	public int top() {
		if (!st.isEmpty()) {
			int x = st.peek();
			return x;
		}
		return -1;
	}

	public int getMin() {
		return stm.peek();
	}
}
