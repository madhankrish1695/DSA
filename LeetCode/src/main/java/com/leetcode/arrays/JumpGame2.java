package com.leetcode.arrays;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 */
public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame2.jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int jump = 0;
        int maxDistance = 0;
        int currentEnd = 0;

        //nums.length - 1 because we know before reaching last index whether we can reach last or not
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, nums[i] + i);
            if (i == currentEnd) {
                jump++;
                currentEnd = maxDistance;
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jump;
    }

}
