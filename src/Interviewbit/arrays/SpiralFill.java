package Interviewbit.arrays;

import java.util.ArrayList;

public class SpiralFill {

	public static void main(String[] args) {
		fill(4);
	}

	private static void fill(int n) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			a.add(temp);
		}
		
		
		int s = 1;
		int lim = 1<<n;
		int si = 0; int ei = n-1;
		int sl = 0; int el = n-1;
		while(s != lim) {
			
			ArrayList<Integer> r1 = a.get(sl);
			for(int j=si;j<ei;j++) {
				r1.add(s++);
			}
			
			
			for(int j=sl;j<el;j++) {
				ArrayList<Integer> temp = a.get(j);
				temp.add(s++);
			}
			sl++;
			
			for(int j=ei;j>si;j--) {
				ArrayList<Integer> temp = a.get(el);
				temp.add(0,s++);
			}
			
			el--;
			
			for(int j=el;j>=sl;j--) {
				ArrayList<Integer> temp = a.get(j);
				temp.add(si,s++);
			}
			si++;
			ei--;
			
			print(a);
		}
		
		
		
	}
	
	private static void print(ArrayList<ArrayList<Integer>> aa) {
		for(int i=0;i<aa.size();i++) {
			ArrayList<Integer> aaa = aa.get(i);
			for(int j=0;j<aaa.size();j++) {
				System.out.print(aaa.get(j)+" ");
			}
			System.out.println();
		}

		System.out.println("-----------");
	}

}
