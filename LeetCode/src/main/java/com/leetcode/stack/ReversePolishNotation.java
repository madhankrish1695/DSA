package com.leetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(reversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(reversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int applyOperator(Integer a, Integer b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
