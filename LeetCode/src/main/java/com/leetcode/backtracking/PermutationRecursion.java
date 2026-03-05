package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationRecursion {

    public static void main(String[] args) {

        PermutationRecursion permutationRecursion = new PermutationRecursion();
        int[] nums = {1, 2, 3};   // Sample data

        List<List<Integer>> result = permutationRecursion.permuteRecursion(nums);

        // Print permutations
        System.out.println("All Permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permuteRecursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backTrack(result, nums, new ArrayList<>(), visit);
        return result;
    }

    public void backTrack(List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] visit) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                current.add(nums[i]);
                backTrack(result, nums, current, visit);
                visit[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
