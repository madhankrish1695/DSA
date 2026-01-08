package com.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        int maxStreak = 0;
        for (int num : nums) {
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numsSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxStreak = Math.max(currentStreak, maxStreak);
            }
        }
        return maxStreak;
    }
}
