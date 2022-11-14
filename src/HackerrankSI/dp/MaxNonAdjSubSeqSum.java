package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaxNonAdjSubSeqSum {

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

            long ans = getMaxSub(ar, len);
            out.write(ans + "\n");
        }

        out.flush();
        br.close();
        out.close();
    }

    private static long getMaxSub(int[] a, int len) {

        long[] dp = new long[] { a[0], a[1] };

        for (int i = 2; i < a.length; i++) {
            long temp = dp[1];
            dp[1] = dp[0] + a[i];
            dp[0] = Math.max(dp[0], temp);
        }

        return Math.max(dp[0], dp[1]);

    }

}
