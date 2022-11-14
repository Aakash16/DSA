package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeFear {

	private static int N = 1000001;
	private static boolean[] visited = new boolean[N];
	private static int[] pCountArr = new int[N];

	static {

		// False means index is prime number
		visited[0] = true;
		visited[1] = true;

		int sqr = (int) Math.ceil(Math.sqrt(N - 1));

		pCountArr[0] = 0;
		pCountArr[1] = 0;
		pCountArr[2] = 0;
		

		for (int i = 2; i < sqr; i++) {

			if (!visited[i]) {

				int j = 2;
				while (j * i < N) {
					visited[i * j] = true; // True means index is not prime
					j++;
				}

			}
		}
		
		
		for(int i=2;i<pCountArr.length;i++) {
			
			
			
			if(!visited[i] && isValidprime(i))
				pCountArr[i] = pCountArr[i-1] + 1;
			else
				pCountArr[i] = pCountArr[i-1];
			
			//System.out.println(i + " " + pCountArr[i]);
		}

		//System.out.println("finish");
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());
			
			String c = Integer.toString(pCountArr[num]);
			out.write(c);
		}

		br.close();
		out.close();
	}

	private static boolean isValidprime(int N) {

                       int tens = 10;
                int dup_num = N;
                int digCount = getDig(dup_num);

                if (digCount == -1) // skipping 0 containing prime
                    return false;

                boolean prev = true;
                while (digCount > 0) {

                    int remainder = dup_num % (tens);

                    if (prev && !visited[remainder]) {
                        prev = true;

                    } else {
                        prev = false;
                    }
                    tens *= 10;
                    digCount--;
                }

                if (prev)
                    return true;


        return false;

    }

	private static int getDig(int n) {
        int c = 0;
        while (n != 0) {
            int zero = n % 10;

            if (zero == 0) { // if zero found return.
                c = -1;
                // System.out.println("skipping for " + n);
                break;
            }
            n = n / 10;
            ++c;
        }

        return c;
    }
}
