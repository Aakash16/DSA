package Leetcode;

import java.util.HashMap;

public class LongestSubstring {

    public static void main(String[] args) {
         System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max= 0;
        int count = 0;
        char d = Character.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(d!=c) {
                if (map.get(c) == null) {
                    count++;
                    map.put(s.charAt(i), 1);
                } else {
                    d = s.charAt(i);
                    max = count;
                    count = 1;
                    map.clear();
                }
            }
        }
        return (Math.max(max, count)) ;
    }
}
