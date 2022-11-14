package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class VerticalOrder {
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


			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

			map = getVLevelOrder(root, 0, map);

			Iterator<Integer> itr = map.keySet().iterator();

			while (itr.hasNext()) {
				int n = itr.next();
				ArrayList<Integer> list = map.get(n);
				for (int x : list) {
					out.write(x + " ");
				}
				out.write("\n");

			}
			out.write("\n");
		}

		br.close();
		out.close();

	}

	private static TreeMap<Integer, ArrayList<Integer>> getVLevelOrder(Node root, int v,
			TreeMap<Integer, ArrayList<Integer>> map) {

		if (root == null)
			return map;

		int key = v;
		if (!map.containsKey(key)) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			map.put(key, list);
		} else {
			ArrayList<Integer> list = map.get(key);
			list.add(root.data);
			Collections.sort(list);
			map.put(key, list);
		}

		getVLevelOrder(root.left, v - 1, map);

		getVLevelOrder(root.right, v + 1, map);

		return map;
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
