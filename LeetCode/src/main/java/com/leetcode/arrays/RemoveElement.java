package com.leetcode.arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    // Time O(n) Space O(1)
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p1++] = nums[i];
            }
        }
        return p1;
    }
}
