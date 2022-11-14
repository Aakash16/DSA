package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {


	/* Name of the class has to be "Main" only if the class is public. */
		public static void main (String[] args) throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
			long tc = Long.parseLong(br.readLine());

			for (int t = 0; t < tc; t++) {
				String[] ints = br.readLine().trim().split("\\s+");
				
				long a = Long.parseLong(ints[0]);
				long b = Long.parseLong(ints[1]);
				
				ints = br.readLine().trim().split("\\s+");
				long s = 0;
				long[] ar = new long[ints.length];
				for(int i=0;i<ints.length;i++){
				    ar[i] =  Long.parseLong(ints[i]);
				    s+=ar[i];
				}
				
				if(s%ints.length == 0){
				    out.write(ar[0]+"\n");
				}else{
				    out.write(-1);
				}
			
			}

			br.close();
			out.close();

		}
	

}
