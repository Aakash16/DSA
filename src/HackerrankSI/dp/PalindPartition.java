package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindPartition {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			int len = Integer.parseInt(br.readLine());

			String str = br.readLine();
			int mLen = findMinPartiton(str, len);
			
			out.write(mLen+"\n");
			
		}

		out.flush();
		br.close();
		out.close();
	}
	
	private static int findMinPartiton(String s, int len) {
		
		 int[] min = new int[len]; 
	        boolean[][] dp = new boolean[len][len]; 
	  
	  
	        // Every substring of length 1 is a palindrome 
	        for (int i = 0; i < len; i++) { 
	            dp[i][i] = true; 
	        } 
	  
	        /* i is substring length. Build the solution  
	        in bottom up manner by considering all substrings  
	        of length starting from 2 to n. */
	        for (int i = 2; i <= len; i++) { 
	            // For substring of length i, set different 
	            // possible starting indexes 
	            for (int j = 0; j < len - i + 1; j++) { 
	                int k = j + i - 1; // Set ending index 
	  
	                // If i is 2, then we just need to 
	                // compare two characters. Else need to 
	                // check two corner characters and value 
	                // of dp[i+1][j-1] 
	                if (i == 2) 
	                    dp[j][k] = (s.charAt(j) == s.charAt(k)); 
	                else
	                    dp[j][k] = (s.charAt(j) == s.charAt(k)) && dp[j + 1][k - 1]; 
	            } 
	        } 
	  
	        for (int i = 0;  i < len; i++) { 
	            if (dp[0][i] == true) 
	                min[i] = 0; 
	            else { 
	                min[i] = Integer.MAX_VALUE; 
	                for (int j = 0;  j < i; j++) { 
	                    if (dp[j + 1][i] == true && 1 + min[j] < min[i]) 
	                        min[i] = 1 + min[j]; 
	                } 
	            } 
	        } 
		
		
		return min[len-1];
		
	}

}
