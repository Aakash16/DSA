package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RevSentence {

	private static int[] arr = new int[10000];

	private static int N = 10000;
	private static int top = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		
		for (int t = 0; t < tc; t++) {

			String[] sub = br.readLine().trim().split("\\s+");

			String opr = sub[0];

			//System.out.println("opr: " + opr);

			switch (opr) {

			case "push":

				int val = Integer.parseInt(sub[1]);

				if (top != N) {
					arr[++top] = val;
				}

				break;

			case "pop":
				if (top >= 0) {
					System.out.println(arr[top--]);
				} else {
					System.out.println("Empty");
				}

				break;

			}

		}

		br.close();
		out.close();
	}

}
