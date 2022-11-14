package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class NodesAtDistK2 {

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
			HashMap<Integer, Node> map = new HashMap<Integer, Node>();

			map.put(ar[0], root);

			for (int i = 1; i < len; i++) {
				ar[i] = Integer.parseInt(s2[i]);
				insert(root, ar[i], map);
			}
			Node m = map.get(n1);
			ArrayList<Integer> k = distanceK(root, m, n2);
			System.out.println(k.size());
			out.write("\n");

		}

		br.close();
		out.close();

	}

	private static ArrayList<Integer> distanceK(Node root, Node target, int K) {
		ArrayList<Integer> ans = new ArrayList<>();
		distanceKFromRoot(target, K, ans);
		ArrayList<Node> path = new ArrayList<>();
		childNodes(root, target, K, path, ans);
		return ans;
	}

	private static boolean childNodes(Node root, Node target, int K, ArrayList<Node> path, ArrayList<Integer> ans) {
		if (root == null)
			return false;
		if (root == target) {
			int count = K - 1;
			Node child = target;
			for (int i = path.size() - 1; i >= 0 && count >= 0; i--) {
				Node current = path.get(i);
				if (current.left == child) {
					current.left = null;
					distanceKFromRoot(current, count, ans);
					current.left = child;
				} else if (current.right == child) {
					current.right = null;
					distanceKFromRoot(current, count, ans);
					current.right = child;
				}
				child = current;
				count--;
			}
			return true;
		}
		path.add(root);
		boolean ret = childNodes(root.left, target, K, path, ans);
		path.remove(path.size() - 1);
		if (ret)
			return true;
		path.add(root);
		ret = childNodes(root.right, target, K, path, ans);
		path.remove(path.size() - 1);
		return ret;
	}

	private static void distanceKFromRoot(Node root, int k, ArrayList<Integer> ans) {
		if (root == null)
			return;
		if (k == 0) {
			ans.add(root.data);
			return;
		}
		distanceKFromRoot(root.left, k - 1, ans);
		distanceKFromRoot(root.right, k - 1, ans);
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
