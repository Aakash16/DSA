package HackerrankSI.trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rhyme {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		BTrie root = new BTrie(0);
		BTrie temp = root;
		for (int t = 0; t < tc; t++) {

			String word = br.readLine();
			int len = word.length();
			insert(root, word, len);

		}

		for(int i=0;i<26;i++) {
			if(root.c[i]!=null)
			System.out.println("--" + (char)(i+'a') + " " + i);	
		}
		
		tc = Integer.parseInt(br.readLine());// queries
		
		
		for (int t = 0; t < tc; t++) {
			String word = br.readLine();
			int len = word.length();

			
			int ans = getMaxLen(temp, word, len);
			out.write(ans + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	private static int getMaxLen(BTrie root, String w, int len) {
		int idx = len - 1;
		int ans = 0;

		while (idx >= 0 && root != null) {
			char b = (char) (w.charAt(idx--) - 'a');
			
			root = root.c[b];
			
			if(root != null)
			ans = root.len;
		}
		return ans;
	}

	/*
	 * private static void printChar(BTrie root, int[] a) { for (int i = 0; i < 26;
	 * i++) { if (root != null && a[i] > 0) { char c = (char) (i + 'a');
	 * System.out.print(c + ":" + root.c[c].count + " "); } } System.out.println();
	 * }
	 */

	private static void insert(BTrie proot, String word, int len) {

		BTrie root = proot;
		for (int p = 0; p < len; p++) {
			char b = (char) (word.charAt(len - 1 - p) - 'a');

			if (root.c[b] == null) {
				root.c[b] = new BTrie(len);
			} else {
				root.setMaxLen(len);
			}
			root = root.c[b];
		}

		// System.out.println("max: " + cnt);
	}

	static class BTrie {
		int len;
		BTrie[] c;

		public BTrie(int len) {
			this.len = len;
			c = new BTrie[26];
		}

		public void setMaxLen(int l) {
			len = Math.max(len, l);
		}
	}
}
