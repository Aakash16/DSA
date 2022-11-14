package Interviewbit.linklist;

public class Rotate {

	static class ListNode {
		int val;
		ListNode next;
	}

	public static void main(String[] args) {

	}

	public ListNode rotateRight(ListNode A, int B) {

		if (B == 0 || A == null)
			return A;

		ListNode itr = A;
		int len = 0;

		while (itr != null) {

			itr = itr.next;
			len++;
		}

		if (B >= len)
			B %= len;
		if (B == 0)
			return A;

		ListNode prev = null;
		ListNode cur = A;

		for (int i = 1; i <= (len - B); i++) {

			prev = cur;
			cur = cur.next;
		}

		prev.next = null;
		ListNode savedCur = cur;

		while (cur.next != null) {
			cur = cur.next;
		}

		cur.next = A;
		return savedCur;
	}
}
