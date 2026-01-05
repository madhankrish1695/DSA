package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;


/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 **/
public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphicUsingMap("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphicUsingMap("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphicUsingArray("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphicUsingArray("foo", "bar"));
    }

    //O(n) time and O(n) space
    public boolean isIsomorphicUsingMap(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (stMap.containsKey(sChar)) {
                if (!stMap.get(sChar).equals(tChar)) return false;
            } else {
                if (stMap.containsValue(tChar)) return false;
            }
            stMap.put(sChar, tChar);
            tsMap.put(tChar, sChar);
        }

        return true;
    }

    //O(n) time O(1) space
    public boolean isIsomorphicUsingArray(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sArr = new int[128];
        int[] tArr = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sArr[sChar] != tArr[tChar]) {
                return false;
            }

            //Store last seen index + 1 (to avoid default 0 conflict)
            sArr[sChar] = i + 1;
            tArr[tChar] = i + 1;
        }

        return true;
    }
}
