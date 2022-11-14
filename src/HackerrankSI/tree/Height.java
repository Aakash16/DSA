package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Height {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			int[] ar = new int[len];

			Node root = new Node(Integer.parseInt(s[0]));

			for (int i = 1; i < len; i++) {
				ar[i] = Integer.parseInt(s[i]);
				insert(root, ar[i]);
			}

			int h = getHeight(root);
			out.write(h + " \n");

		}

		br.close();
		out.close();

	}

	private static int getHeight(Node root) {

		if (root == null)
			return -1;

		int lh = getHeight(root.left);
		int rh = getHeight(root.right);

		return Math.max(lh + 1, rh + 1);

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

	/*
	 * private static void printInOrder(Node root, BufferedWriter out)throws
	 * IOException { if (root == null) return;
	 * 
	 * printInOrder(root.left, out); out.write(root.data + " ");
	 * printInOrder(root.right, out); }
	 * 
	 * private static void printPostOrder(Node root, BufferedWriter out)throws
	 * IOException { if (root == null) return;
	 * 
	 * printPostOrder(root.left, out); printPostOrder(root.right, out);
	 * out.write(root.data + " "); }
	 * 
	 * private static void printPreOrder(Node root, BufferedWriter out)throws
	 * IOException { if (root == null) return;
	 * 
	 * out.write(root.data + " "); printPreOrder(root.left, out);
	 * printPreOrder(root.right, out); }
	 */

	static class Node {

		int data;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

}
