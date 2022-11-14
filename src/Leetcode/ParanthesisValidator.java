package Leetcode;

import java.util.Stack;

public class ParanthesisValidator {

    public static void main(String[] args) {
        int len = longestValidParentheses("(()(()))", 0);
        System.out.println(len);
    }

    public static int longestValidParentheses(String str,int i) {

        if (str.isEmpty())
            return 0;

        int max = 0;
        for (int j = 0; j < str.length(); j++) {
            String temp = str.substring(0,str.length()-j);
            if(isValid(temp))
            {
                max = Math.max(temp.length(),max);
            }
        }

        return Math.max(longestValidParentheses(str.substring(i+1), i), max);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
