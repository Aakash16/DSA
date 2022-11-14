package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*
  5
1
2
5
50
100
 * */

/*3
5
10
1040
16640*/
/* 3, 5, 6, 9, 10, 12, 17, 18, 20....
 *    11 - 1 - 3 1
 *   101 - 2 - 5 2
 *   110 - 2 - 6 3
 *  1001 - 4 - 9 4
 *  1010 - 4 - 10 5
 *  1100 - 4 - 12 6
 * 10001 - 5 - 17 7-----
 * 10010 - 5 - 18 8
 * 10100 - 5 - 20 9
 * 11000 - 5 - 24 10-----
 *100001 - 6 - 33 11
 * */

/*
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * */

// 3, 5, 6, 9, 10, 12, 17, 18, 20
public class TwoSet {

	final static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			long num = Long.parseLong(br.readLine());
			getnum(num);
		}

		br.close();//isPower
		out.close();
	}

	
	private static void getnum(long num) {
		
		double d = (1 + 4 *  num);
		double re = -1 / (2);
		
	double root	 = Math.sqrt(d) / (2) + re;
	
	System.out.println(root);
	}
	

}
