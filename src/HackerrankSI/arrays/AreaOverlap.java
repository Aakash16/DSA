package HackerrankSI.arrays;
import java.util.Scanner;

public class AreaOverlap{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			long x11 = sc.nextLong();
			long y11 = sc.nextLong();
			long x12 = sc.nextLong();
			long y12 = sc.nextLong();

			long x21 = sc.nextLong();
			long y21 = sc.nextLong();
			long x22 = sc.nextLong();
			long y22 = sc.nextLong();

			if (x11 > x21) {
				x11 = x11 + x21;
				x21 = x11 - x21;
				x11 = x11 - x21;

				x12 = x12 + x22;
				x22 = x12 - x22;
				x12 = x12 - x22;

				y11 = y11 + y21;
				y21 = y11 - y21;
				y11 = y11 - y21;

				y12 = y12 + y22;
				y22 = y12 - y22;
				y12 = y12 - y22;

			}

			float a1 = area(x11, y11, x12, y12);
			float a2 = area(x21, y21, x22, y22);

			float f = 0, c = 0;

			System.out.println(a1 + " " + a2);

			if (x11 <= x21 && x22 <= x12 && y21 >= y11 && y22 <= y12) {
				f = a1;
			}
			
			else if (x11 <= x21 && x21 < x12 && x22 > x12 && y11 <= y21 && y22 <= y12) {// 8
				System.out.println("case8");
				c = area(x21, y21, x12, y22);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x21 < x12 && x22 < x12 && y11 <= y21 && y22 >= y12) {// 8-2
				System.out.println("case8-2");
				c = area(x21, y21, x22, y12);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x21 <= x12 && x22 > x12 && y21 >= y11 && y21 <= y12 && y22 > y12) {// 1
				System.out.println("case1");
				c = area(x21, y21, x12, y12);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x21 <= x12 && x22 > x12 && y22 >= y11 && y22 <= y12 && y21 < y11) {// 2
				System.out.println("case2");
				c = area(x21, y11, x11, y22);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x22 <= x12 && y21 >= y11 && y21 < y12 && y22 > y12) {// 3
				System.out.println("case3");
				c = area(x21, y21, x21, y12);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x22 <= x12 && y22 <= y12 && y22 > y11 && y21 < y11) {// 4
				System.out.println("case4");
				c = area(x21, y11, x22, y22);
				f = a1 + a2 - c;
			}

			else if (x11 <= x21 && x22 <= x12 && y21 < y11 && y22 > y12) {// 5
				System.out.println("case5");
				c = area(x21, y11, x22, y12);
				f = a1 + a2 - c;
			}

			

			else if (x11 <= x21 && x21 <= x12 && x22 > x12 && y21 <= y11 && y22 >= y12) {// 9
				System.out.println("case9");
				c = area(x21, y11, x12, y12);
				f = a1 + a2 - c;
			}

			else if (x22 >= x12 || y21 >= y12 || y11 >= y22) {
				f = a1 + a2;
			}

			else if (x11 == x21 && x22 >= x12 && y22 >= y12 && y21 <= y11) {// 10
				f = a2;
			}

			System.out.println("c:" + c);
			System.out.println(String.format("%.0f", f));
		}

		sc.close();
	}

	private static float area(long x11, long y11, long x12, long y12) {

		long len = Math.abs(x11 - x12);
		long wid = Math.abs(y11 - y12);

		return len * wid;

	}
}