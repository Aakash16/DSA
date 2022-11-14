package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsBalanced {

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

			out.write(isHeightBalanced(root) ? "Yes" : "No");
			out.write(System.lineSeparator());
		}

		br.close();
		out.close();

	}

	private static boolean isHeightBalanced(Node root) {

		if (root == null)
			return true;

		int l = getHeight(root.left);
		int r = getHeight(root.right);

		int d = Math.abs(l - r);

		if (d <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right)) {
			return true;
		}

		return false;
	}

	private static int getHeight(Node node) {
		if (node == null)
			return 0;

		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
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
