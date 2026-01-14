package com.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
    }

    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        Stack<Character> parenthesesStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                parenthesesStack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                Character pop = parenthesesStack.pop();
                if ('(' != pop) return false;
            } else if (s.charAt(i) == '}') {
                Character pop = parenthesesStack.pop();
                if ('{' != pop) return false;
            } else if (s.charAt(i) == ']') {
                Character pop = parenthesesStack.pop();
                if ('[' != pop) return false;
            }
        }
        return true;
    }
}
