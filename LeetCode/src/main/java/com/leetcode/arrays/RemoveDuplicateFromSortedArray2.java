package com.leetcode.arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicateFromSortedArray2 {

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray2 removeDuplicateFromSortedArray2 = new RemoveDuplicateFromSortedArray2();
        System.out.println(removeDuplicateFromSortedArray2.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicateFromSortedArray2.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int p1 = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[p1 - 2]) {
                nums[p1++] = nums[i];
            }
        }
        return p1;
    }
}
