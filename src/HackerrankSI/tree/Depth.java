package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Depth {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			Node root = new Node(Integer.parseInt(s[0]), 0);
			out.write(0 + " ");
			for (int i = 1; i < len; i++) {
				insert(root, Integer.parseInt(s[i]), 0, out);
			}

			out.write("\n");
		}

		br.close();
		out.close();

	}

	private static Node insert(Node root, int x, int dep, BufferedWriter out) throws IOException {

		if (root == null) {
			root = new Node(x, dep);
			out.write(dep + " ");
			return root;
		}

		if (x > root.data) {
			root.right = insert(root.right, x, dep + 1, out);
		} else if (x < root.data) {
			root.left = insert(root.left, x, dep + 1, out);
		} else {
			return root;
		}

		return root;
	}

	/*
	 * private static void printDepth(Node root){ if (root == null) { return; }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

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
