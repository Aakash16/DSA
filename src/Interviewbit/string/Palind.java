package Interviewbit.string;

public class Palind {

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static int isPalindrome(String A) {
		
		
		A = A.replaceAll("[^a-zA-Z]", "").toLowerCase();
		System.out.println(A);
		int ans = 0;
		int len = A.length();

		for (int i = 0; i < len; i++) {

			int subL = 0;
			int p1 = i;
			int p2 = i;

			while (p1 >= 0 && p2 < len) {

				if (A.charAt(p1) == A.charAt(p2)) {

					subL++;
					p1--;
					p2++;
				} else {
					break;
				}
			}
			ans = Math.max(ans, (subL * 2 - 1));

			subL = 0;
			p1 = i;
			p2 = i + 1;

			while (p1 >= 0 && p2 < len) {

				if (A.charAt(p1) == A.charAt(p2)) {
					subL++;
					p1--;
					p2++;
				} else {
					break;
				}
			}
			ans = Math.max(ans, (subL * 2));
		}

		if (ans == A.length())
			return 1;
		else
			return 0;
	}
}
