package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"a"}));
    }

    //Time: O(n * k) Space: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] charArray = new int[26];
            for (char c : strs[i].toCharArray()) {
                charArray[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charArray.length; j++) {
                sb.append(charArray[j]).append("#");
            }

            groupAnagramMap.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(groupAnagramMap.values());
    }
}
