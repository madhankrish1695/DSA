package com.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSum(new int[]{0, 1, 1}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int compliment = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == compliment) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        while (start < end - 1 && nums[start] == nums[start + 1]) start++;
                        while (start + 1 < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] > compliment) {
                        end--;
                    } else if (nums[start] + nums[end] < compliment) {
                        start++;
                    }
                }

            }
        }
        return result;
    }
}
