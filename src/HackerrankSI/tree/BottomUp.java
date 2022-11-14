package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class BottomUp {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			Node root = new Node(Integer.parseInt(s[0]), 0);
			for (int i = 1; i < len; i++) {
				insert(root, Integer.parseInt(s[i]));
			}

			getLevelUpOrder(root, out);
			out.write(System.lineSeparator());

		}

		br.close();
		out.close();

	}

	private static Node insert(Node root, int x) {

		if (root == null) {
			root = new Node(x);
			return root;
		}

		if (x > root.data) {
			root.right = insert(root.right, x);
		} else if (x < root.data) {
			root.left = insert(root.left, x);
		} else {
			return root;
		}

		return root;
	}

	private static void getLevelUpOrder(Node root, BufferedWriter out) throws IOException {

		if (root == null)
			return;

		Stack<LinkedList<Integer>> st = new Stack<LinkedList<Integer>>();
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
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

				//System.out.println(list1.toString());
				st.push(list1);
				list1 = new LinkedList<Integer>();
				count = list.size();
			}
		}

		while (!st.empty()) {
			list1 = st.pop();
			for (int i = 0; i < list1.size(); i++) {
				out.write(list1.get(i) + " ");
			}
			out.write(System.lineSeparator());
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
