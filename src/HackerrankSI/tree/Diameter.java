package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Diameter {

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

			// long ans = getDia(root, 0);
			long ans = diameterOpt(root,0);
			System.out.println(ans);
			out.write(System.lineSeparator());
		}

		br.close();
		out.close();

	}

	static long diameterOpt(Node root, Height height) {

		Height lh = new Height();
		Height rh = new Height();
		if (root == null) {
			height.h = 0;
			return 0;
		}

		long ldiameter = diameterOpt(root.left, lh);
		long rdiameter = diameterOpt(root.right, rh);

		System.out.println(ldiameter + " " + rdiameter + " " + lh.h + " " + rh.h + " " + height.h);
		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	}

	static long diameterOpt(Node root, long height) {

		long lh = 0;
		long rh = 0;
		if (root == null) {
			height = 0;
			return 0;
		}

		long ldiameter = diameterOpt(root.left, lh);
		long rdiameter = diameterOpt(root.right, rh);

		System.out.println(ldiameter + " " + rdiameter + " " + lh + " " + rh + " " + height);
		height = Math.max(lh, rh) + 1;

		return Math.max(lh + rh + 1, Math.max(ldiameter, rdiameter));
	}

	
	static class Height {
		int h;
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