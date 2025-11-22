package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate1(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, -100, 3, 99};
        rotateArray.rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, -100, 3, 99};
        rotateArray.rotate2(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    //O(n) and O(n)
    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = k; i < nums.length + k; i++) {
            result[i % nums.length] = nums[i - k];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    //O(n) and O(1)
    public void rotate2(int[] nums, int k) {
        int n = nums.length - 1;
        reverse(nums, 0, n);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
