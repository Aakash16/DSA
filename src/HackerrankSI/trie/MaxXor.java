package HackerrankSI.trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MaxXor {

	private static int MAX_BITS = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			ArrayList<ArrayList<Integer>> bitList = new ArrayList<ArrayList<Integer>>();
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");

			BTrie root = new BTrie();
			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
				ArrayList<Integer> list = getBits(ar[p]);
				insert(root, ar[p], list);
				bitList.add(list);
			}

			System.out.println("MAX " + MAX_BITS);
			for (int p = 0; p < len; p++) {
				int x = getMaxXor(root, ar[p], bitList.get(p));
				System.out.print(x + " ");
			}
			System.out.println();
		}

		out.flush();
		br.close();
		out.close();
	}

	private static ArrayList<Integer> getBits(int x) {

		ArrayList<Integer> bits = new ArrayList<Integer>();
		while (x > 0) {
			bits.add(0, x % 2);
			x = x / 2;
		}

		//System.out.println(bits.size());
		for (int i = 0; i < 32; i++) {
			if (bits.get(i) == 1) {
				break;
			} else if (bits.get(i) == 0)
				bits.remove(0);
		}
		MAX_BITS = Math.max(MAX_BITS, bits.size());
		//System.out.println(bits.toString());
		return new ArrayList<Integer>(bits);
	}

	private static int getMaxXor(BTrie root, int x, ArrayList<Integer> list) {
		System.out.println("rec " + list.toString());
		int ans = 0;
		for (int i = 0; i < MAX_BITS; i++) {
			int b = 0;
			
			if(i<list.size())
				b = list.get(i);
			
			int r = (b == 1 ? 0 : 1);
			System.out.println(" b " + b + " r " + r);
			
			if (root.c[r] != null) {
				ans += (1 << r);
				System.out.println(" found " + (1 << r) + " " + ans);
				
			} else {
				ans += (1 << b);
				System.out.println(" reset " + (1 << b) + " " + ans);
				
			}
		}

		return ans;
	}

	private static void insert(BTrie root, int x, ArrayList<Integer> ar) {

	//	System.out.print(x + " bits: ");
		for (int i = 0; i < ar.size(); i++) {

			int b = ar.get(i);
			//System.out.print(b + " ");
			if (root.c[b] == null) {
			//	System.out.print("new ");
				root.c[b] = new BTrie();
				root = root.c[b];
			} else {
			//	System.out.print("already ");
				root = root.c[b];
			}
		}
		//System.out.println();
	}

	private static int checkBit(int i, int j) {
		return (i >> j) & 1;
	}

	static class BTrie {
		BTrie[] c;

		public BTrie() {
			c = new BTrie[2];
		}
	}
}
