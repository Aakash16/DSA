package SmartInterviews.backtracking;

public class WordPartition {
	public static void main(String[] args) {
		String str = "SmartInterviews";
		int len = str.length();
		String[] sub = new String[] { "Smart", "art", "Int", "erview","xyz","abc", "views" };

		for (int i = 0; i < len; i++) {
			String sb = str.substring(i, len);
			//System.out.println("S=>" + sb);
			part(sb, sub, sb.length(), 0);
		}
	}

	private static boolean part(String str, String[] sub, int len, int idx) {

		if (idx == len - 1) {
			return true;
		}

		for (int i = idx; i < str.length(); i++) {

			String subs = str.substring(0, i+1);
			//System.out.println("i:" + subs);
			for (int j = 0; j < sub.length; j++) {
				if (subs.equals(sub[j])) {
					System.out.println(subs);
					String s = str.substring(i);
					//System.out.println("n:"+s);
					part(s, sub, s.length(), 0);
				}
			}
		}

		return false;
	}
}
