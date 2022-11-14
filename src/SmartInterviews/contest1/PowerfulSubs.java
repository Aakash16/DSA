package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PowerfulSubs {

	static long andVal = 0;;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int size = Integer.parseInt(br.readLine());

			int[] ar = new int[size];
			String[] ints = br.readLine().trim().split("\\s+");

			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			for (int p = 0; p < size; p++) {

				ar[p] = Integer.parseInt(ints[p]);
			}

			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			printSubs(ar, size, -1, new ArrayList<Integer>(), ans);

			boolean is = false;
			for (int i = 0; i < ans.size(); i++) {
				ArrayList<Integer> list = ans.get(i);
				int num = ans.get(i).get(0);
				for (int j = 0; j < list.size(); j++) {

					int n = list.get(j);
					num = num & n;
				}
				
				int c = 0;
				while (num >= 1) {

					int n = (int) num % 2;
					c += n;
					num = num >> 1;
				}

				if (c == 1) {
					is = true;
				} 

			}
			
			if (is) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> printSubs(int[] ar, int n, int index, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> ans) {
		if (index == n) {
			return ans;
		}

		if (list.size() > 0)
			ans.add(new ArrayList<Integer>(list));


		for (int i = index + 1; i < n; i++) {

			list.add(ar[i]);
			printSubs(ar, n, i, list, ans);
			list.remove(list.size() - 1);
		}
		return ans;
	}

}
