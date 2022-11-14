package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Candy {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {

			String num = br.readLine();

			NUM nums = removeTrailingZeroes(num);
			long n = Long.parseLong(nums.getS());

			long log = log2(n);
			
			System.out.println( log + " -- " + nums.getN() + " " + nums.getS());
			if (log == -1) {
				out.write("NO\n");
				continue;
			}
			 

			if (log < nums.getN())
				out.write("YES\n");
			else
				out.write("NO\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	static NUM removeTrailingZeroes(String s) {
		
		
		StringBuilder sb = new StringBuilder(s);
		int c = 0;
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
			sb.setLength(sb.length() - 1);
			c++;
		}

		NUM nn = new NUM(c, sb.toString());

		return nn;
	}

	public static long log2(long x) {
		int c = 0;
		while (x >= 1) {
			if (x % 2 == 0) {
				x = x/2;
				c++;
			} else {
				return -1;
			}
		}
		return (long) c;
	}

	static class NUM {
		int n;
		String s;

		public NUM(int n, String s) {
			super();
			this.n = n;
			this.s = s;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

	}
}
