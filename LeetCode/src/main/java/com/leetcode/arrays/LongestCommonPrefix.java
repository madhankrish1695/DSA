package com.leetcode.arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    private String getCommonPrefix(String prefix, String word) {
        while (!word.startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }
}
