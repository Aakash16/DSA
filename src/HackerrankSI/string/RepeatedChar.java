package HackerrankSI.string;
import java.util.Scanner;

public class RepeatedChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		String s = "";

		int j = 0;
		sc.nextLine();
		for (int i = 0; i < count; i++) {
			s = sc.nextLine();

			for (j = 0; j < s.length(); j++) {

				char c = s.charAt(j);
				if (s.substring(j + 1).contains(String.valueOf(c))) {
					System.out.println(c);
					break;
				}

			}
			//2 3 5 7 11 13 17 19 23 29

			if (j == s.length())
				System.out.println(".");
		}

		sc.close();
	}
}
