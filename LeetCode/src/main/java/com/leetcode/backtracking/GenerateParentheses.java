package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, n, "");
        return result;
    }

    private void backtrack(List<String> result, int left, int right, String current) {

        if (left < 0 || right < 0 || right < left) return;

        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            backtrack(result, left - 1, right, current + '(');
        }

        if (right > 0) {
            backtrack(result, left, right - 1, current + ')');
        }
    }
}
