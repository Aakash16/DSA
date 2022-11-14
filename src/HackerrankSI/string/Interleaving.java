package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Interleaving {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			int l1 = s[0].length();
			int l2 = s[1].length();

			System.out.println("Case #" + (t + 1) + ":");
			// inter(s[1], s[0], l2, l1, new ArrayList<Character>(), 0, 0);
			ArrayList<String> ans = new ArrayList<String>();
			interleavings("", s[0], s[1], ans);
			String[] ss = ans.toArray(new String[0]);
			Arrays.sort(ss);
			
			for(String str : ss) {
				System.out.println(str);
			}
		}
	}

	public static void interleavings(String res, String X, String Y, ArrayList<String> out) {
// insert res into set if we have reached end of both Strings
		if (X.length() == 0 && Y.length() == 0) {
			out.add(res);
			return;
		}

// if String X is not empty, append its first character in the
// result and recur for remaining substring
		if (X.length() > 0) {
			interleavings(res + X.charAt(0), X.substring(1), Y, out);
		}

// if String Y is not empty, append its first character in the
// result and recur for remaining substring
		if (Y.length() > 0) {
			interleavings(res + Y.charAt(0), X, Y.substring(1), out);
		}
	}

	private static void inter(String s1, String s2, int n1, int n2, ArrayList<Character> list, int idx1, int idx2) {

		/*
		 * if (idx1 == n1 && idx2 == n2) {
		 * 
		 * System.out.println(list); return; }
		 * 
		 * if (idx1 < n1 && idx2 < n2) { char c = s1.charAt(idx1); char d =
		 * s2.charAt(idx2);
		 * 
		 * if (c > d) { list.add(c); inter(s1, s2, n1, n2, list, idx1 + 1, idx2);
		 * list.remove(list.size() - 1); } else { list.add(d); inter(s1, s2, n1, n2,
		 * list, idx1, idx2 + 1); list.remove(list.size() - 1); } }
		 * 
		 * while (idx1 < n1) { char c = s1.charAt(idx1); list.add(c); inter(s1, s2, n1,
		 * n2, list, idx1 + 1, idx2); }
		 * 
		 * while (idx2 < n2) { char c = s2.charAt(idx2); list.add(c); inter(s1, s2, n1,
		 * n2, list, idx1, idx2 + 1); }
		 */

		if (idx2 < n2) {
			char c = s1.charAt(idx2);
			char d = s2.charAt(idx2);

			if (c > d) {
				list.add(c);
				inter(s1, s2, n1, n2, list, idx1 + 1, idx2);
				list.remove(list.size() - 1);
			} else {
				list.add(d);
				inter(s1, s2, n1, n2, list, idx1, idx2 + 1);
				list.remove(list.size() - 1);
			}
		}

		if (idx1 < n1) {
			list.add(s1.charAt(idx1));
			inter(s1, s2, n1, n2, list, idx1 + 1, idx2);
			list.remove(list.size() - 1);
		}

		if (idx2 < n2) {
			list.add(s2.charAt(idx2));
			inter(s1, s2, n1, n2, list, idx1, idx2 + 1);
			list.remove(list.size() - 1);
		}

	}
}
