package com.leetcode.arrays;

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("the sky is blue"));
        System.out.println(reverseWordsInString.reverseWords("  hello world  "));
        System.out.println(reverseWordsInString.reverseWords("a good   example"));
        System.out.println(reverseWordsInString.reverseWordsWithoutSplit("the sky is blue"));
        System.out.println(reverseWordsInString.reverseWordsWithoutSplit("  hello world  "));
        System.out.println(reverseWordsInString.reverseWordsWithoutSplit("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    public String reverseWordsWithoutSplit(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            int start = i + 1;
            if (sb.length() > 0) sb.append(" ");
            sb.append(s, start, end + 1);
        }
        return sb.toString();
    }
}
