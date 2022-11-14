package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;

public class PickingNumbers {
	
	public static void main(String[] args) {
		//4,97,5,97,97,4,97,4,97,97,97,97,4,4,5,5,97,5,97,99,4,97,5,97,97,97,5,5,97,4,5,97,97,5,97,4,97,5,4,4,97,5,5,5,4,97,97,4,97,5,4,4,97,97,97,5,5,97,4,97,97,5,4,97,97,4,97,97,97,5,4,4,97,4,4,97,5,97,97,97,97,4,97,5,97,5,4,97,4,5,97,97,5,97,5,97,5,97,97,97
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4,5,97,97,97));
		int[] ar = list.stream().mapToInt(a->a).toArray();
		
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		//ar = mergeSort(ar, 0, ar.length - 1);
		int[] ac = compress(ar);
		int[] fr = getFreqAr(ar, ac);
		
		int fmax=0;
		for(int i=0;i<fr.length;i++) {
			if(fr[i]>fmax)
				fmax = fr[i];
		}
		System.out.println(Arrays.toString(ac));
		System.out.println(Arrays.toString(fr));
		int max = 0;
		for(int i=0;i<ac.length-1;i++) {
		
			int sum = 0;
			if(ac[i+1]-ac[i] == 0 || ac[i+1]-ac[i] == 1) {
				sum += fr[i+1]+fr[i];
				
				System.out.println("s:" + sum);
				if(sum>max) {
					max = sum;
				}
			}
		}
		
		if(max == 0)
			max = ar.length;
		if(max < fmax)
			max = fmax;
		
		System.out.println(max);
	}

	private static int[] getFreqAr(int[] ar, int[] cr) {

		int[] fr = new int[cr.length];
		int j = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == cr[j]) {
				fr[j]++;
			} else {

				j++;
				fr[j]++;

			}
		}

		return fr;

	}

	private static int[] compress(int[] ar) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (i < ar.length) {
			if (i == 0) {
				list.add(ar[i]);
				i++;
			} else {

				if (ar[i] != list.get(list.size() - 1)) {
					list.add(ar[i]);
				}
				i++;
			}
		}

		int[] temp = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			temp[k] = list.get(k);
		}

		return temp;
	}
	
	private static int[] mergeSort(int[] ar, int lo, int hi) {

		if (lo == hi) {
			return ar;
		}

		int mid = (lo + hi) / 2;

		mergeSort(ar, lo, mid);
		mergeSort(ar, mid + 1, hi);
		merge(ar, lo, mid, hi);

		return ar;

	}

	private static int[] merge(int[] ar, int lo, int mid, int hi) {

		int[] temp = new int[hi - lo + 1];

		int idx = 0, p1 = lo, p2 = mid + 1;

		while (p1 <= mid && p2 <= hi) {

			if (ar[p1] <= ar[p2])
				temp[idx++] = ar[p1++];
			else
				temp[idx++] = ar[p2++];
		}

		while (p1 <= mid) {
			temp[idx++] = ar[p1++];
		}

		while (p2 <= hi) {
			temp[idx++] = ar[p2++];
		}

		int k = 0;
		for (int i = lo; i <= hi; i++) {
			ar[i] = temp[k++];
		}

		return ar;
	}
}
