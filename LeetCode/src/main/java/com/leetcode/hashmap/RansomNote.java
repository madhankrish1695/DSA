package com.leetcode.hashmap;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charArray = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            charArray[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (charArray[index] <= 0) return false;
            charArray[index]--;
        }
        return true;
    }
}
