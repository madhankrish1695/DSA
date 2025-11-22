package com.leetcode.arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
 * <p>
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 */
public class RemoveDuplicateFromSortedArray1 {

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray1 removeDuplicateFromSortedArray1 = new RemoveDuplicateFromSortedArray1();
        System.out.println(removeDuplicateFromSortedArray1.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicateFromSortedArray1.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int p1 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[p1++] = nums[i];
            }
        }
        return p1;
    }
}
