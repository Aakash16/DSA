package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ConvertAnagram {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			String s1 = s[0];
			String s2 = s[1];

			/*ArrayList<Character> list1 = new ArrayList<Character>();
			ArrayList<Character> list2 = new ArrayList<Character>();

			for (int i = 0; i < n; i++) {
				list1.add(s1.charAt(i));
			}

			for (int i = 0; i < m ;i++) {
				list2.add(s2.charAt(i));
			}

			Collections.sort(list1);
			Collections.sort(list2);*/
			
			char[] cr1 = s1.toCharArray();
			char[] cr2 = s2.toCharArray();
			
			
			Arrays.sort(cr1);
			Arrays.sort(cr2);
			
			s1 = String.valueOf(cr1);
			s2 = String.valueOf(cr2);
			
			System.out.println(s1);
			System.out.println(s2);
			
			int m = s1.length();
			int n = s2.length();
			
			
			int count = 0;
			
			int[] c1 = new int[26];
			int[] c2 = new int[26];
			
			for(int i=0;i<m;i++) {
				c1[s1.charAt(i) - 'a']++;
			}
			
			for(int i=0;i<n;i++) {
				c2[s2.charAt(i) - 'a']++;
			}
			
			System.out.println(Arrays.toString(c1));
			System.out.println(Arrays.toString(c2));
			
			for(int i=0;i<26;i++) {
				if(c1[i] != c2[i]) {
					count += Math.abs(c1[i]-c2[i]);
				}
			}
			
			System.out.println(count);
		}

		br.close();
		out.close();
	}

}
