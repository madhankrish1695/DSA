package com.practice.arrays;

/**
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * <p>
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s1 = "racecar";
        String t1 = "carrace";
        String s2 = "jar";
        String t2 = "jam";

        System.out.println(validAnagram.isAnagram(s1,t1));
        System.out.println(validAnagram.isAnagram(s2,t2));
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] charArr = new int[26];

        for(int i = 0; i < s.length(); i++){
            charArr[s.charAt(i)-'a']++;
            charArr[t.charAt(i)-'a']--;
        }

        for (int i : charArr){
            if(i != 0) return false;
        }

        return true;

    }
}
