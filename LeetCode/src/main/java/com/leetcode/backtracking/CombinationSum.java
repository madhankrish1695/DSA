package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, current, i);
            current.remove(current.size() - 1);
        }
    }
}
