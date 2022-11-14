package LinkedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {

	private final static int ADD = 1;
	private final static int DELETE = 2;
	private final static int INSERT = 3;
	private final static int PRINT = 4;
	private final static int EXIT = 6;
	private final static int DUP = 5;
	private final static int SWAP = 7;

	private final static String MSG_ADD_NODE = "Enter node value: ";
	private final static String MSG_INSERT_NODE = "Enter node position: ";

	private static class MyList {

		private Node head = null;
		private Node current = null;
		private int len = 0;

		public void addNode(int val) {

			Node node = new Node(val);

			if (head == null) {
				head = node;
				current = head;
			}

			current.next = node;
			current = node;

			len++;
		}

		public void addNode(Node cur, int val) {

			Node node = new Node(val);
			node.next = cur.next;
			cur.next = node;

			len++;
		}

		public void print() {

			Node cur = head;
			while (cur != null) {

				System.out.print(cur.data + " ");
				cur = cur.next;
			}

			System.out.print("\n");
		}

		public void insert(int pos, int val) {

			Node cur = head;

			while (pos > 0) {

				pos--;
				cur = cur.next;

			}

			addNode(cur, val);
		}

		public int getLength() {
			return len;
		}

		public void swap(int to, int from) {

			Node toNode = getNodeAt(to);
			Node fromnode = getNodeAt(from);

			Node temp = toNode;
			toNode.data = fromnode.data;
			fromnode.data = temp.data;
		}

		public Node getNodeAt(int pos) {

			int count = 0;
			Node cur = head;
			while (count != pos) {
				cur = cur.next;
				count++;
			}

			System.out.print(" node at " + pos + " " + cur.data);
			return cur;
		}

		public void remDuplicate() {
			remDup(head);
		}

		public Node remDup(Node cur) {

			if (cur.data == cur.next.data) {
				cur.next = cur.next.next;
				cur = cur.next;
				return remDup(cur);

			}

			while (cur.data == cur.next.data) {

			}

			return remDup(cur);
		}
	}

	private static class Node {

		private int data;
		private Node next;

		Node(int val) {
			data = val;
			next = null;
		}

		public int getNodeValue() {
			return data;
		}

		public void setData(int val) {
			data = val;
		}
	}

	public static void main(String[] args) {

		MyList myList = new MyList();

		int choice = getUserInput();
		while (choice != EXIT) {

			switch (choice) {

			case ADD:
				int val = getValue(MSG_ADD_NODE);
				myList.addNode(val);

				break;

			case INSERT:
				val = getValue(MSG_ADD_NODE);
				int pos = getValue(MSG_INSERT_NODE);
				myList.insert(pos, val);

				break;

			case PRINT:
				myList.print();
				break;

			case DUP:
				myList.remDuplicate();

				break;
			case SWAP:
				int to = getValue("enter to");
				int from = getValue("enter from");
				myList.swap(to, from);

				break;
			default:
				break;
			}

			choice = getUserInput();

		}

	}

	private static int getUserInput() {

		int choice = 0;
		final String msg = "\nPlease select option:\n";
		final String option1 = "1. Add node\n";
		final String option2 = "2. Delete node\n";
		final String option3 = "3. Insert node\n";
		final String option4 = "4. Print list\n";
		final String option6 = "5. rem dup list\n";
		final String option7 = "7. swap\n";
		final String option5 = "6. Exit\n";

		System.out.print(msg + option1 + option2 + option3 + option4 + option5 + option7);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			choice = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			System.out.println("Please input valid ineger");
		}

		// System.out.println("User choice: " + choice);

		return choice;

	}

	private static int getValue(String msgId) {
		int val = 0;
		System.out.print(msgId);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			val = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			System.out.println("Please input valid ineger");
		}

		return val;
	}

}
