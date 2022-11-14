package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class specialStr {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			//int len = Integer.parseInt(br.readLine());

			String S = br.readLine();
			int len = S.length();
			int[] z = new int[len];
			int[] o = new int[len];

			if(S.charAt(0) - '0' == 0)
			z[0] = 1;
			else
			o[0] = 1;

			for (int p = 1; p < len; p++) {

				if (S.charAt(p) - '0' == 0) {
					z[p] = z[p - 1] + 1;
					o[p] = o[p - 1] ;
				} else {
					o[p] = o[p - 1] + 1;
					z[p] = z[p - 1] ;
				}
			}

			int lim = (int)((Math.sqrt(1 + 4*len))/2);
			System.out.println(lim);
			int ans = 0;
			for(int i=1;i<=lim;i++) {
				int l = i+i*i;
				System.out.println("L: " + l);
				
				if(z[l-1]  == o[l-1]*o[l-1])
					ans +=1;
				
				for(int j=l;j<len;j++) {
					System.out.println("s " + z[j-l] + " " + o[j-l]);
					if(z[j-l] == o[j-l]*o[j-l])
						ans+=1;
				}
			}
			System.out.println(ans);
			System.out.println(Arrays.toString(z));
			System.out.println(Arrays.toString(o));
			
			out.write(System.lineSeparator());
		}

		out.flush();
		br.close();
		out.close();
	}

}
