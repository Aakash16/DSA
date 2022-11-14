package CodeForces.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int len = Integer.parseInt(br.readLine());

		if (len % 2 != 0) {
			out.write("NO\n");
			out.flush();
			out.close();
			br.close();
			return;
		}
		String[] sub = br.readLine().trim().split("\\s+");

		int e = 0;
		int o = 0;

		for (int t = 0; t < len; t++) {
			int c = Integer.parseInt(sub[t]);

			if (c % 2 == 0)
				e++;
			else
				o++;
		}

		if (e == o && e % 2 == 0) {
			out.write("YES\n");
		} else {
			out.write("NO\n");
		}
		out.flush();
		out.close();
		br.close();

	}

}
