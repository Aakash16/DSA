package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumRootToLeaf {

	private static int K = 1000000007;

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

			out.write(computeSum(root, 0) + "");
			out.write(System.lineSeparator());
		}

		br.close();
		out.close();

	}

	private static long computeSum(Node root, long v) {

		if (root == null) {
			return 0;
		}

		v = (long) (((v % K * Math.pow(10, dig(root.data)) % K) % K + root.data % K) % K);

		if (isLeafNode(root))
			return v;
		else
			return (computeSum(root.left, v) % K + computeSum(root.right, v) % K) % K;
	}

	private static boolean isLeafNode(Node root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

	private static int dig(int data) {
		int c = 0;
		while (data > 0) {
			data /= 10;
			c++;
		}
		return c;
	}

	public static int countDigit(int no) {
        if (no < 10) {
            return 10;
        } else if (no >= 10 && no < 100) {
            return 100;
        } else if (no >= 100 && no < 1000) {
            return 1000;
        } else if (no >= 1000 && no < 10000){
            return 10000;
        } else {
            return 100000;
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
