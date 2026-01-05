package com.leetcode.hashmap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charArray = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i)]++;
            charArray[t.charAt(i)]--;
        }
        for (int count : charArray) {
            if (count != 0) return false;
        }
        return true;
    }
}
