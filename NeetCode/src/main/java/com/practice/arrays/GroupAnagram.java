package com.practice.arrays;

import java.util.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 </p>
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */
public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();

        System.out.println(groupAnagram.groupAnagrams(new String[] {"act","pots","tops","cat","stop","hat"}));
        System.out.println(groupAnagram.groupAnagrams(new String[] {"x"}));
        System.out.println(groupAnagram.groupAnagrams(new String[] {""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String val : strs) {
            int[] charArr = new int[26];
            for (int j = 0; j < val.length(); j++) {
                charArr[val.charAt(j) - 'a']++;
            }
            String key = Arrays.toString(charArr);
            resultMap.putIfAbsent(key, new ArrayList<>());
            resultMap.get(key).add(val);
        }
        return new ArrayList<>(resultMap.values());
    }

}
