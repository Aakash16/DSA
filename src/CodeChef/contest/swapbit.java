package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swapbit {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());

			String S = br.readLine();
			String A = br.readLine();

			int c = 0, f = 0 , s = 0;
			for (int p = 0; p < len; p++) {

				if (S.charAt(p) == '1')
					f++;
				if (A.charAt(p) == '1')
					s++;

					if ((S.charAt(p) ^ A.charAt(p)) == 1)
						c++;
			}

			
			out.write((c % 2 == 0 && (f == s)) ? "YES" : "NO");
			out.write(System.lineSeparator());
		}

		out.flush();
		br.close();
		out.close();
	}

}
