package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CheckSubseq {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			String s1 = s[0];
			String s2 = s[1];

			int m = s[0].length();

			int count = 0;
			for (int i = 0; i < m; i++) {
				char c = s1.charAt(i);
				String sub = String.valueOf(c);
				if (s2.contains(sub)) {

					int p = s2.indexOf(sub);
					s2 = s2.substring(p + 1);
					count++;
				}
			}

			if (count == m) {
				out.write("Yes" + "\n");
			} else {
				out.write("No" + "\n");
			}
		}

		br.close();
		out.close();
	}

}
