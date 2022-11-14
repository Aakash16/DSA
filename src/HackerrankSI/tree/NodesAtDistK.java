package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NodesAtDistK {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {

			String[] s = br.readLine().split("\\s+");
			int len = Integer.parseInt(s[0]);
			int n1 = Integer.parseInt(s[1]);
			int n2 = Integer.parseInt(s[2]);

			String[] s2 = br.readLine().split("\\s+");

			int[] ar = new int[len];

			Node root = new Node(Integer.parseInt(s2[0]));

			for (int i = 1; i < len; i++) {
				ar[i] = Integer.parseInt(s2[i]);
				insert(root, ar[i]);
			}

			printAllNodes(root, n1, n2);

			out.write("\n");

		}

		br.close();
		out.close();

	}

	private static void printAllNodes(Node root, int node, int distance) {
		int pl = getDistBetNodes(root, node, 0);
		Path(root, node, pl, distance);
	}

	private static void print(Node root, int node, Node prev, int k, boolean searchingDown, int count) {
		if (root != null) {
			if (k == 0 && root.data != node) {
				System.out.print(root.data + " ");
			}
			if (searchingDown) {
				print(root.left, node, prev, k - 1, searchingDown, count);
				print(root.right, node, prev, k, searchingDown, count);
			} else {
				if (root.left != prev) {
					print(root.left, node, prev, k - 1, searchingDown, count);
				}
				if (root.right != prev) {
					print(root.right, node, prev, k - 1, searchingDown, count);
				}
			}
		}
	}

	private static Node Path(Node root, int dest, int k, int n) {

		if (root == null)
			return null;

		Node l = Path(root.left, dest, k - 1, n);
		Node r = Path(root.right, dest, k - 1, n);

		if (root.data == dest || l != null || r != null) {
			if (k == 0) {
				print(root, dest, l, n - k, true, 0);
			} else {
				print(root, dest, r, n - k, false, 0);
			}

			return root;
		}
		
		return null;
	}

	private static int getDistBetNodes(Node root, int n, int len) {

		if (root == null || root.data == n)
			return len;

		if (n > root.data) {
			return getDistBetNodes(root.right, n, len + 1);
		} else {
			return getDistBetNodes(root.left, n, len + 1);
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

	private static int find(Node root, int d) {

		if (root == null)
			return 0;

		if (d == 0)
			return 1;
		return find(root.left, d - 1) + find(root.right, d - 1);
	}

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
	}
}
