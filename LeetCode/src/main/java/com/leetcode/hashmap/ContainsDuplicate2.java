package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {
        ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
        System.out.println(containsDuplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsDuplicate2.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsDuplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> uniqueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueMap.containsKey(nums[i])) {
                int abs = Math.abs(i - uniqueMap.get(nums[i]));
                if (abs <= k) return true;
            }
            uniqueMap.put(nums[i], i);
        }
        return false;
    }
}
