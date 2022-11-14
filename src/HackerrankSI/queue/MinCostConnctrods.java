package HackerrankSI.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinCostConnctrods {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");
			
			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}
		
			out.write(minCost(ar, len)+"\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	static int minCost(int arr[], int n) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
  
        for (int i = 0; i < n; i++) { 
            pq.add(arr[i]); 
        } 
  
        int res = 0; 
  
        while (pq.size() > 1) { 
            int first = pq.poll(); 
            int second = pq.poll(); 
  
            res += first + second; 
            pq.add(first + second); 
        } 
  
        return res; 
    }

}
