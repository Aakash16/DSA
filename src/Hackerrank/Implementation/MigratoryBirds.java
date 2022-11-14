package Hackerrank.Implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MigratoryBirds {


    public static void main(String[] args) throws IOException {
    	
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 4, 4, 4, 5, 3));
    	
    	int[] arr  = new int[5];
    	
    	int max = 0, idx = 0;
    	for(int i=list.size()-1;i >= 0;i--) {
    		arr[list.get(i)-1]++;
    		
    		
    	}
    	
    	for(int i=0;i<5;i++) {
    		int n = arr[i];
    		if(n>max) {
    			max = n;
    			idx = i+1;
    		}
    	}
    	System.out.println(max + " " + idx);
    	System.out.println(Arrays.toString(arr));
       
    }
}
