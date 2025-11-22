package com.leetcode.arrays;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * </p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * </p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge1(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        mergeSortedArray.merge1(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge2(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        mergeSortedArray.merge2(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1));
    }

    //space O(n) time O(m+n)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }

        if (i != m) {
            System.arraycopy(nums1, i, result, index, m - i);
        }

        if (j != n) {
            System.arraycopy(nums2, j, result, index, n - j);
        }

        System.arraycopy(result, 0, nums1, 0, m + n);

    }

    //space O(1) time O(m+n)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        // if p2 end first the remaining elements in nums1 is already sorted. No need to sort again.
        // If p1 ends first we need to put remaining elements of nums2 in nums1

        if (p2 >= 0) {
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }
}
