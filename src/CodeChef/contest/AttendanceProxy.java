package CodeChef.contest;

import java.util.Scanner;

public class AttendanceProxy {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int cc = 0; cc < tc; cc++) {

			int len = sc.nextInt();

			char ar[] = new char[len];

			String line = sc.next();

			for (int c = 0; c < len; c++) {
				ar[c] = line.charAt(c);
			}

			int p = (int)Math.ceil(0.75 * len);
			System.out.println(p);
			int dp = 0;
			int b = 0;
			for (int i = 0; i < len; i++) {

				if (dp >= p) {
					b = i;
					break;
				}

				if (i > 1 && i < (len - 2) && ar[i] == 'A') {

					if (ar[i + 1] == 'P' || ar[i + 2] == 'P' || ar[i - 1] == 'P' || ar[i - 2] == 'P') {
						dp++;
					}
				}

				else if (i == 0 || i == 1 || i == len - 1 || i == len - 2) {
					if (ar[i] == 'P')
						dp++;
					
				}

				System.out.println(dp);
			}
			
			System.out.println(b);

		}

		sc.close();
	}

}
