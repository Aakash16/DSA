package SmartInterviews.string;

public class SmallestSubsInAContainsAllB {

	public static void main(String[] args) {

		String A = "axyquzeyqeuabceugdxevbdxq";
		String B = "queue";

		Sol2(A, B);

	}

	private static void Sol1(String A, String B) { // O(N^3 * M)

		int N = A.length();
		int M = B.length();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) { // N

			for (int j = i; j <= N; j++) { // N

				char[] sub = A.substring(i, j).toCharArray();

				if (sub.length > M) {
					int cn = 0;
					for (int k = 0; k < M; k++) { // M

						char c = B.charAt(k);
						for (int h = 0; h < sub.length; h++) { // N
							if (sub[h] == c) {
								sub[h] = '.';
								cn++;
								break;
							}
						}
					}

					if (cn == M)
						ans = Math.min(ans, sub.length);

				}

			}
		}

		System.out.println(ans);

	}

	private static void Sol2(String A, String B) { // O (N*N*(N+26)) = O(N^2 * (N+26) + M)

		int N = A.length();
		int M = B.length();
		int ans = Integer.MAX_VALUE;

		int[] qarr = counArr(B); // M

		for (int i = 0; i < N; i++) { // N

			for (int j = i; j <= N; j++) { // N

				String sub = A.substring(i, j);

				if (sub.length() > M) {

					boolean is = true;

					int[] s1 = counArr(sub); // N

					for (int k = 0; k < 26; k++) { // 26
						if (qarr[k] > 0) {
							if (s1[k] < qarr[k])
								is = false;
						}
					}

					if (is)
						ans = Math.min(ans, sub.length());
				}
			}
		}

		System.out.println(ans);
	}

	private static void Sol5(String A, String B) {

		int N = A.length();
		int M = B.length();
		int ans = Integer.MAX_VALUE;

		int p1 = 0;
		int p2 = 0;

		while (B.charAt(B.length() - 1) != A.charAt(p2)) {
			p2++;

		}

	}

	private static int[] counArr(String A) {
		int[] carr = new int[26];

		for (int i = 0; i < A.length(); i++) {
			carr[A.charAt(i) - 'a']++;
		}

		return carr;
	}

}
