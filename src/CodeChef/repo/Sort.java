package CodeChef.repo;

public class Sort {

	public static void Merge_sort(int a[]) {
		int len = a.length;
		if (len < 2)
			return;
		int mid = len / 2;
		int l[] = new int[mid];
		int r[] = new int[len - mid];
		for (int i = 0; i < mid; i++)
			l[i] = a[i];
		for (int i = mid; i < len; i++)
			r[i - mid] = a[i];

		Merge_sort(l);
		Merge_sort(r);
		Merge(l, r, a);
	}

	public static void Merge(int[] l, int[] r, int a[]) {
		int nl = l.length;
		int nr = r.length;
		int i = 0, j = 0, k = 0;

		while (i < nl && j < nr) {
			if (l[i] > r[j]) {
				a[k] = l[i];
				k++;
				i++;
			} else {
				a[k] = r[j];
				k++;
				j++;
			}

			while (i < nl) {
				a[k] = l[i];
				k++;
				i++;
			}
			while (j < nr) {
				a[k] = r[j];
				k++;
				j++;
			}
		}
	}

}
