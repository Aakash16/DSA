package HackerrankSI.string;
import java.util.ArrayList;

public class ReducedString {

	public static void main(String[] args) {
		String str = "aaabccddd";
		ArrayList<Character> list = new ArrayList<Character>();
		String res = "";
		list.add(str.charAt(0));
		
		for (int i = 1; i < str.length(); i++) {

			char t = str.charAt(i);

			char d = getLastChar(list);

			//System.out.print(d);

			if (d == t) {
				if (list.size() > 0)
					list.remove(list.size() - 1);
			} else {
				list.add(t);
			}

		}

		StringBuilder builder = new StringBuilder(list.size());
		for (Character ch : list) {
			builder.append(ch);
		}
		String s = builder.toString().length() > 0 ? builder.toString() : "Empty String";
		System.out.println(s);

	}

	private static char getLastChar(ArrayList<Character> list) {

		char c = 0;
		if (list != null && list.size() > 0) {
			c = list.get(list.size() - 1);
		}

		return c;
	}
}
