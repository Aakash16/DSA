package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DistAppl {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			long N = Long.parseLong(ints[0]);
			long K = Long.parseLong(ints[1]);

			if (K == 1) {
				out.write("NO\n");
			} else {
				
				long pow = 1;
				int loop = 0;
		        while (pow < N) {
		            pow = pow * K;
		            loop++;
		        }
		        
				if (pow == N && loop>1) {
					out.write("NO\n");
				} else {
					out.write("YES\n");
				}
			}
			out.flush();
		}

		br.close();
		out.close();

	}

}
