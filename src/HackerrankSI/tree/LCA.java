package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class LCA {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {

			String[] s = br.readLine().split("\\s+");
			int len = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);

			int[] ar = new int[len];
			String[] s2 = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				ar[i] = Integer.parseInt(s2[i]);
			}

			HashMap<Integer, Node> map = new HashMap<Integer, Node>();

			Node root = new Node(ar[0]);
			map.put(ar[0], root);

			for (int i = 1; i < len; i++) {
				insert(root, ar[i], map);
			}

			for (int i = 0; i < q; i++) {
				String[] s3 = br.readLine().split("\\s+");
				int a = Integer.parseInt(s3[0]);
				int b = Integer.parseInt(s3[1]);

				Node n1 = map.get(a);
				Node n2 = map.get(b);

				Node t = getLCA(root, n1.data, n2.data);
				out.write(t.data + " ");
			}

			out.write("\n");

		}

		br.close();
		out.close();

	}

	private static Node insert(Node root, int x, HashMap<Integer, Node> map) {

		if (root == null) {
			root = new Node(x);
			map.put(x, root);
			return root;
		}

		if (x > root.data) {
			root.right = insert(root.right, x, map);
		} else if (x < root.data) {
			root.left = insert(root.left, x, map);
		} else {
			return root;
		}

		return root;
	}

	private static Node getLCA(Node root, int A, int B) {

		if (root == null)
			return null;

		if (root.data > A && root.data > B)
			return getLCA(root.left, A, B);

		if (root.data < A && root.data < B)
			return getLCA(root.right, A, B);

		return root;
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
