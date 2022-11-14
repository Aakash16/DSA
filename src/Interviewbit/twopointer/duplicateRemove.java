package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class duplicateRemove {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,2,3,3,5,5,6));
		
		System.out.println(remoDup(list));
		
	}
	
	private static int remoDup(ArrayList<Integer> a) {
		
		 	int i = 0;
	        int k = 1;
	        while(i<a.size() && k<a.size()){
	        	
	        	if(!a.get(i).equals(a.get(k))) {
	        		k++;
	        		i++;
	        	}else {
	        		while(  k<a.size() &&  i<a.size() && a.get(i).equals(a.get(k))){
	        			k++;
	        		}
	        		
	        		i=k;
	        		k++;
	        	}
	        	
	        	
	        }

	        System.out.println(a);
	        return i-1;
	}
}
