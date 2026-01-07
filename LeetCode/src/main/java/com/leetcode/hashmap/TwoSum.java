package com.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> compliMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compli = target - nums[i];
            if (compliMap.containsKey(compli)) {
                return new int[]{i, compliMap.get(compli)};
            }
            compliMap.put(nums[i], i);
        }

        return null;
    }
}
