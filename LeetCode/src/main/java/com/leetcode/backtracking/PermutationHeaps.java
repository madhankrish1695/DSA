package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationHeaps {
    public static void main(String[] args) {
        PermutationHeaps permutationHeaps = new PermutationHeaps();
        int[] nums = {1, 2, 3};   // Sample data

        List<List<Integer>> result = permutationHeaps.permute(nums);

        // Print permutations
        System.out.println("All Permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, nums.length);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] nums, int n) {
        if (n == 1) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                backtrack(result, nums, n - 1);
                if (n % 2 == 0) {
                    swap(i, n - 1, nums);
                } else {
                    swap(0, n - 1, nums);
                }
            }
        }
    }

    private void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
