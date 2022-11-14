package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class ZigZagLevelOrder {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			Node root = new Node(Integer.parseInt(s[0]), 0);
			for (int i = 1; i < len; i++) {
				insert(root, Integer.parseInt(s[i]), 0);
			}

			printLevelZigzag(root, out);
			out.write(System.lineSeparator());
		}

		br.close();
		out.close();

	}

	private static Node insert(Node root, int x, int dep) {

		if (root == null) {
			root = new Node(x, dep);
			return root;
		}

		if (x > root.data) {
			root.right = insert(root.right, x, dep + 1);
		} else if (x < root.data) {
			root.left = insert(root.left, x, dep + 1);
		} else {
			return root;
		}

		return root;
	}

	private static void printLevelZigzag(Node root, BufferedWriter out) throws IOException {

		if (root == null)
			return;

		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		boolean dir = false;
		int count = list.size();

		while (count != 0) {

			list1.add(list.peek().data);

			if (list.peek().left != null)
				list.add(list.peek().left);

			if (list.peek().right != null)
				list.add(list.peek().right);

			list.remove();
			count = count - 1;

			if (count == 0) {

				if (!dir) {
					Collections.reverse(list1);
					dir = true;
				} else {
					dir = false;
				}

				for (int x : list1) {
					out.write(x + " ");
				}

				list1 = new LinkedList<Integer>();
				count = list.size();
			}
		}
		
		

	}

	static class Node {

		int data;
		Node left;
		Node right;
		int depth;

		public Node(int data, int depth) {
			super();
			this.data = data;
			this.depth = depth;
		}

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

}
