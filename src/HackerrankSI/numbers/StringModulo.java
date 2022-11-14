package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringModulo {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			int l1 = s[0].length();

			long num = Long.parseLong(s[1]);
			long ans =0;
			for(int i=0;i<l1;i++) {
				ans = ((10*ans) + s[0].charAt(i) - '0')%num;
				
			}
			
			System.out.println(ans);

		}
	}

}
