package com.leetcode.SlidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(11, new int[]{4, 4, 4, 4, 4}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
