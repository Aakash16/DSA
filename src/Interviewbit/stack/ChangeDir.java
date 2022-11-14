package Interviewbit.stack;

import java.util.Arrays;
import java.util.Stack;

public class ChangeDir {

	public static void main(String[] args) {

		String a = "/a/./b/../../c/";
		a = "/a/../../../c/d";
		a = "/../";
		a = simplifyPath(a);
		System.out.println(a);
	}

	private static String simplifyPath(String A) {

		Stack<String> st = new Stack<String>();

		String[] sub = A.split("/");

		System.out.println(Arrays.toString(sub));

		for (int i = 0; i < sub.length; i++) {

			if (!sub[i].isEmpty()) {

				if (sub[i].equals("..")) {
					if (!st.isEmpty()) {
						st.pop();
					}
				} else if (!sub[i].equals(".")) {

					st.push(sub[i]);
					System.out.println("pus " + sub[i] + " " + st.size());
				}
			}
		}

		String ans = "";
		int sz = st.size();

		for (int i = 0; i < sz; i++) {

			ans = "/" + st.pop() + ans;
		}

		if(ans.isEmpty())
			ans = "/";
		return ans;
	}
}
