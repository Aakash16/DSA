package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class IsBST {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < l; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split("\\s+");

			HashMap<Integer, Node> map = new HashMap<>();
			int key = Integer.parseInt(s[0]);
			Node root = new Node(key);
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
						// System.out.println("already " + key + " add left " + left);
						Node n = map.get(key);

						n.left = new Node(left);
						map.put(left, n.left);
					} else {

						// System.out.println("new add left " + key + " add " + left);
						root.left = new Node(left);
						map.put(left, root.left);
					}
				}

				idx = idx + 1;
				if (idx < len) {

					int right = Integer.parseInt(s[idx]);

					if (map.containsKey(key)) {

						// System.out.println("already " + key + " add right " + right);
						Node n = map.get(key);
						n.right = new Node(right);
						map.put(right, n.right);

					} else {

						// System.out.println("new add right " + key + " add " + right);
						root.right = new Node(right);
						map.put(right, root.right);
					}
				}
			}
			boolean is = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

			if (is)
				out.write("True" + "\n");
			else
				out.write("False" + "\n");
		}

		br.close();
		out.close();

	}

	private static boolean isBST(Node root, int a, int b) {

		if (root == null)
			return true;

		return (root.data > a) && (root.data < b) && isBST(root.left, a, root.data) && isBST(root.right, root.data, b);

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
