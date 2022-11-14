package SmartInterviews.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KMP {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] subs = br.readLine().trim().split("\\s+");
			long count = getKMPatch(subs[1], subs[0]);
			System.out.println(count);

		}
		
	}
	
	static int getKMPatch(String A, String B) {
	    
	    int[] lcp = getkArray(B);
	    System.out.println(Arrays.toString(lcp));
	    int i = 0, j = 0;
	    while (i < A.length() && j != B.length()) {
	        if (A.charAt(i) == B.charAt(j)) {
	            j++;
	        }
	        else {
	            if (j > 0) {
	                j = lcp[j - 1];
	                continue;
	            }
	        }
	        i++;
	    }
	    return (i - j) <= (A.length() - B.length()) ? (i - j) : -1;
	}

	static int[] getkArray(String A) {
	    int[] kA = new int[A.length()];
	    int len = 0, i = 1;
	    while (i < A.length()) {
	        if (A.charAt(i) == A.charAt(len)) {
	            len++;
	            kA[i] = len;
	            i++;
	        }
	        else {
	            if (len != 0) {
	                len = kA[len - 1];
	            }
	            else {
	                kA[i] = 0;
	                i++;
	            }
	        }
	    }
	    return kA;
	}

}
