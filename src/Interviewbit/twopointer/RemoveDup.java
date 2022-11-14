package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveDup {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(
				Arrays.asList(300,300,300));

		System.out.println(removeDuplicates(list));
	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		Collections.sort(a);
		
		int i = 0;
		int len = a.size();
		while(i < len-1) {
			
			System.out.println(a.get(i)+" " + a.get(i+1));
			if(a.get(i) == a.get(i+1)) {
				System.out.println("same");
				int idx = i+1;
				a.remove(idx);
				len = a.size();
			}
			else {
				i++;
			}
		}
		
		System.out.println(a);
		return a.size();
	}

}
