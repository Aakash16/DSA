package CodeChef;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	public static void main(String[] args) {
		
		int wid;
		float bal;
		Scanner sc = new Scanner(System.in);

		wid = sc.nextInt();
		bal = sc.nextFloat();

		if (wid % 5 == 0 && (wid + 0.5f) <= bal) {
			bal = (bal - (wid + 0.5f));
		}
		
		System.out.println(bal);
		
		sc.close();
	}
}
