package Leetcode;

import java.util.Arrays;

public class MedianSortedArray {
    public static void main(String[] args) {

        double res = findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int[] n1, int[] n2) {
        int p1 = 0;
        int p2 = 0;
        int l1 = n1.length;
        int l2 = n2.length;

        int[] res = new int[l1+l2];
        int c = 0;

        while(p1<l1 && p2<l2){
            while(p1 < l1 && n1[p1] < n2[p2]){
                res[c++] = n1[p1++];
            }
            while(p1<l1 && p2<l2 && n1[p1] > n2[p2]){
                res[c++] = n2[p2++];
            }
            while(p1<l1 && p2<l2 && n1[p1] == n2[p2]){
                res[c++] = n1[p1++];
                res[c++] = n2[p2++];
            }
        }

        while(p1<l1){
            res[c++] = n1[p1++];
        }
        while(p2<l2){
            res[c++] = n2[p2++];
        }

        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));

        return res.length%2 == 0 ? (res[res.length/2] + res[(res.length/2) - 1])/2.0 : res[res.length/2];
    }
}
