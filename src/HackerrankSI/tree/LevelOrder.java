package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class LevelOrder {

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

			//getLevelOrder(root, out);
			//levelOrderTraversal(root);
			out.write("\n");
		}

		br.close();
		out.close();

	}

	private static void getLevelOrder(Node root, BufferedWriter out) throws IOException {

		if (root == null)
			return;

		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		int count = list.size();

		while (count != 0) {
			out.write(list.peek().data + " ");

			if (list.peek().left != null)
				list.add(list.peek().left);

			if (list.peek().right != null)
				list.add(list.peek().right);

			list.remove();
			count = count - 1;

			if (count == 0) {
				out.write(System.lineSeparator());
				count = list.size();
			}
		}
	}
	
	public static boolean printLevel(Node root, int level)
	{
		// base case
		if (root == null) {
			return false;
		}

		if (level == 1)
		{
			System.out.print(root.data + " ");

			// return true if at-least one node is present at given level
			return true;
		}

		boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);

		return left || right;
	}

	// Function to print level order traversal of given binary tree
	public static void levelOrderTraversal(Node root)
	{
		// start from level 1 -- till height of the tree
		int level = 1;

		// run till printLevel() returns false
		while (printLevel(root, level)) {
			System.out.println();
			level++;
		}
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
