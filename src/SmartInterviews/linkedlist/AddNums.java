package SmartInterviews.linkedlist;

import static SmartInterviews.linkedlist.LinkedList.add;

public class AddNums {

	public static void main(String[] args) {

		Node h1 = new Node(3);
		Node n = LinkedList.createNode(5);
		add(h1, n);

		n = LinkedList.createNode(8);
		add(h1, n);

		Node h2 = new Node(9);
		Node n2 = LinkedList.createNode(8);
		add(h2, n2);

		n2 = LinkedList.createNode(2);
		add(h2, n2);
		n2 = LinkedList.createNode(1);
		add(h2, n2);

		// Base.print(h1);
		// Base.print(h2);

		h1 = LinkedList.rev(h1);
		h2 = LinkedList.rev(h2);

		// Base.print(h1);
		// Base.print(h2);

		Node ss = addTwoNumbers(h1, h2);

		Node sum = null;
		int c = 0;
		while (h1 != null && h2 != null) {

			int x = h1 != null ? h1.data : 0;
			int y = h2 != null ? h2.data : 0;

			int s = x + y + c;

			c = s / 10;
			int v = s % 10;

			System.out.println("c:" + c + " s:" + v);

			Node t = new Node(v);
			sum = add(sum, t);

			if (h1 != null)
				h1 = h1.next;

			if (h2 != null)
				h2 = h2.next;
		}

		sum = LinkedList.rev(sum);
		LinkedList.print(ss);
	}

	public static Node addTwoNumbers(Node A, Node B) {
		Node temp = new Node(0);

		Node p1 = A, p2 = B, curr = temp;
		int carry = 0;
		
		while (p1 != null || p2 != null) {
			
			int x = (p1 != null) ? p1.data : 0;
			int y = (p2 != null) ? p2.data : 0;
			
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new Node(sum % 10);
			curr = curr.next;
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
		}
		if (carry > 0) {
			curr.next = new Node(carry);
		}
		return temp.next;
	}
}
