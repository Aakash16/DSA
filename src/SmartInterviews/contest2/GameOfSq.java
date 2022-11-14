package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameOfSq {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int num = Integer.parseInt(br.readLine());
			boolean alice = false;
			while(num>0) {
				
				int n = (int)Math.sqrt(num);
				System.out.println(n);
				
				num -= (n*n);
				
				if(!alice)
					alice = true;
				else {
					alice = false;
				}
			}
			
			if(alice)
				out.write("Win\n");
			else
				out.write("Lose\n");
		}

		br.close();
		out.close();
	}

}
