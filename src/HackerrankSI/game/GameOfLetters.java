package HackerrankSI.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfLetters {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String S = br.readLine();

			int[] count_arr = new int[26];

			int pwr_grt_1 = 0;
			int pw_eq_1 = 0;
			for (int i = 0; i < S.length(); i++) {

				int idx = S.charAt(i) - 'a';
				count_arr[idx]++;

			}

			for (int i = 0; i < 26; i++) {
				if (count_arr[i] > 1)
					pwr_grt_1++;
				if (count_arr[pw_eq_1] == 1)
					pw_eq_1++;
			}
			
			

			if (pw_eq_1 % 2 == 0 && pwr_grt_1 % 2 == 0) { // if both even banta wins
				
				System.out.println("Banta");
				
			} else if (pw_eq_1 % 2 != 0 && pwr_grt_1 % 2 != 0) { // if both odd santa wins
				
				System.out.println("Santa");
				
			} else if (pwr_grt_1 % 2 == 0 && pw_eq_1 %2 !=0) { // if char with fr 1 is odd and >1 are even 
				
				System.out.println("Santa");
				
			} else if (pw_eq_1 % 2 == 0 && pwr_grt_1 % 2 != 0) {
				
				System.out.println("Banta");
			}

		}
	}
}
