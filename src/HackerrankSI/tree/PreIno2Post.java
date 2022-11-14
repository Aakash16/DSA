package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PreIno2Post {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			k = 0;
			int len = Integer.parseInt(br.readLine());
			int[] pre = new int[len];
			int[] ino = new int[len];

			String[] s1 = br.readLine().trim().split("\\s+");
			String[] s2 = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				pre[p] = Integer.parseInt(s1[p]);
				ino[p] = Integer.parseInt(s2[p]);
			}

			Node root = fill(pre, ino, 0, len - 1);
			printPostOrder(root, out);
			out.write(System.lineSeparator());
		}

		out.flush();
		br.close();
		out.close();
	}

	static int k = 0;

	private static Node fill(int[] pre, int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int idx = search(pre[k], in, lo, hi);
		Node root = createNode(pre[k]);
		k++;
		root.left = fill(pre, in, lo, idx - 1);
		root.right = fill(pre, in, idx + 1, hi);

		return root;
	}

	private static void printPostOrder(Node root, BufferedWriter out)throws IOException {
        if (root == null)
            return;

        printPostOrder(root.left, out);
        printPostOrder(root.right, out);
        out.write(root.data + " ");
    }
	private static int search(int x, int[] ar, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			if (ar[i] == x) {
				return i;
			}
		}
		return -1;
	}

	private static Node createNode(int x) {
		return new Node(x);
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
