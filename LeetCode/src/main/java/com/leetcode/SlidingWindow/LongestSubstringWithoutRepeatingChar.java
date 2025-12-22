package com.leetcode.SlidingWindow;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int[] charArray = new int[128];
        int left = 0, right = 0;
        while (right < s.length()) {
            charArray[s.charAt(right)]++;
            while (charArray[s.charAt(right)] > 1) {
                charArray[s.charAt(left)]--;
                left++;
            }
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}
