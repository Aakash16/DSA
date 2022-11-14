package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class CountBST {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			Node root = new Node();
			root = insert(s, len, root);
			// printInOrder(root,out);
			int count = countBST(root, -1);
			System.out.println(count);

		}

		br.close();
		out.close();

	}

	private static Node insert(String[] s, int len, Node root) {
		HashMap<Integer, Node> map = new HashMap<>();
		int key = Integer.parseInt(s[0]);
		root = new Node(key);
		map.put(key, root);

		int lim = 0;
		if (len % 2 == 0) {
			lim = len / 2;
		} else {
			lim = (len - 1) / 2;
		}
		for (int c = 0; c <= lim; c++) {
			key = Integer.parseInt(s[c]);

			int idx = 2 * c + 1;
			if (idx < len) {
				int left = Integer.parseInt(s[idx]);

				if (map.containsKey(key)) {
					Node n = map.get(key);

					n.left = new Node(left);
					map.put(left, n.left);
				} else {

					root.left = new Node(left);
					map.put(left, root.left);
				}
			}

			idx = idx + 1;
			if (idx < len) {

				int right = Integer.parseInt(s[idx]);

				if (map.containsKey(key)) {
					Node n = map.get(key);
					n.right = new Node(right);
					map.put(right, n.right);

				} else {
					root.right = new Node(right);
					map.put(right, root.right);
				}
			}
		}

		return root;
	}

	private static boolean isBST(Node root, int a, int b) {

		if (root == null)
			return true;

		return (root.data > a) && (root.data < b) && isBST(root.left, a, root.data) && isBST(root.right, root.data, b);

	}

	private static int countBST(Node root, int count) {

		if (root == null) {
			return 0;
		}

		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return countBST(root.left, count) + countBST(root.right, count) + 1;
		else
			return countBST(root.left, count) + countBST(root.right, count);

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

		public Node() {

		}

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
