package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsComplete {

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

			int size = size(root);
			out.write(isCompleteBT(root, 0, size) ? "Yes" : "No");
			out.write(System.lineSeparator());
		}

		br.close();
		out.close();

	}

	public static boolean isCompleteBT(Node root, int i, int n) {
		// return if tree is empty
		if (root == null) {
			return true;
		}

		if ((root.left != null && 2 * i + 1 >= n) || !isCompleteBT(root.left, 2 * i + 1, n)) {
			return false;
		}

		if ((root.right != null && 2 * i + 2 >= n) || !isCompleteBT(root.right, 2 * i + 2, n)) {
			return false;
		}

		return true;
	}

	private static int size(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
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
