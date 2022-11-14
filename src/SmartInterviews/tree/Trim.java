package SmartInterviews.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Trim {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			int A = Integer.parseInt(br.readLine());
			int B = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			Node root = new Node(Integer.parseInt(s[0]), 0);
			for (int i = 1; i < len; i++) {
				insert(root, Integer.parseInt(s[i]));
			}

			printInOrder(root, out);
			out.write("\n");
			root = trim(root, A, B);
			printInOrder(root, out);
			out.write("\n");
		}

		br.close();
		out.close();

	}

	private static Node trim(Node root, int A, int B) {

		if (root == null) {
			return null;
		}

		
		root.left = trim(root.left, A, B);
		root.right = trim(root.right, A, B);
		
		if (root.data < A) {
			Node c = root.right;
			root = null;
			return c;
		}
		if (root.data > B) {
			Node c = root.left;
			root = null;
			return c;
		}

		

		return root;
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

	private static void printInOrder(Node root, BufferedWriter out) throws IOException {
		if (root == null)
			return;

		printInOrder(root.left, out);
		out.write(root.data + " ");
		printInOrder(root.right, out);
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
