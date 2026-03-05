package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();

        String digits = "23";

        List<String> combinations = solution.letterCombinations(digits);

        System.out.println("Input: " + digits);
        System.out.println("Output: " + combinations);
        System.out.println("Output Rec: " + solution.letterCombinationsRecursion(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] table = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Queue<String> q = new LinkedList<>();
        q.offer("");

        while (!q.isEmpty()) {
            String current = q.poll();
            if (current.length() == digits.length()) {
                result.add(current);
            } else {
                int digit = Character.getNumericValue(digits.charAt(current.length()));
                String letters = table[digit];
                for (int i = 0; i < letters.length(); i++) {
                    q.add(current + letters.charAt(i));
                }
            }
        }

        return result;
    }

    String[] table = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinationsRecursion(String digits) {
        List<String> result = new ArrayList<>();
        dfs(digits, new StringBuilder(), result);
        return result;
    }

    public void dfs(String digits, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(sb.length()));
        String letters = table[digit];

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
