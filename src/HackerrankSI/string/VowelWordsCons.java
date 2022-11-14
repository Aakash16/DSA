package HackerrankSI.string;

import java.util.Scanner;

public class VowelWordsCons {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		sc.nextLine();

		for (int i = 0; i < count; i++) {
			String s = sc.nextLine().trim();

			int v = 0, con = 0, w = 0;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);

				int fw = j + 1;

				if (c == ' ') {
					if ((s.charAt(fw) != ' '))
						w++;
				} else {
					if (c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e' || c == 'A' || c == 'I' || c == 'O'
							|| c == 'U' || c == 'E') {
						v++;

					} else {
						con++;
					}
				}
			}
			
			if(v>0 || con>0)
				w++;

			System.out.println(w + " " + v + " " + con);
		}

		sc.close();
	}

}
