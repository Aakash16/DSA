package HackerrankSI.string;
import java.util.ArrayList;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		sc.nextLine();
		ArrayList<Character> list = new ArrayList<Character>();

		for (int i = 0; i < count; i++) {
			String s = sc.nextLine();

			
			String[] sub = s.split(" ");
			list.clear();

			if (sub[0].length() == sub[1].length()) {

				for (int j = 0; j < sub[1].length(); j++)
					list.add(sub[1].charAt(j));

				for (int j = 0; j < sub[0].length(); j++) {

					char c = sub[0].charAt(j);
					int in = list.lastIndexOf(c);
					if (in >= 0) {
						char cc = list.remove(in);
					}
				}

				if (list.size() == 0)
					System.out.println("True");
				else
					System.out.println("False");

			} else {
				System.out.println("False");
			}
		}

		sc.close();
	}

}
