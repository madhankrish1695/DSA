package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PermutationQueue {
    public static void main(String[] args) {
        PermutationQueue permutationQueue = new PermutationQueue();
        int[] nums = {1, 2, 3};   // Sample data

        List<List<Integer>> result = permutationQueue.permute(nums);

        // Print permutations
        System.out.println("All Permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());
        for (int num : nums) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> current = q.poll();
                for (int j = 0; j <= current.size(); j++) {
                    List<Integer> temp = new ArrayList<>(current);
                    temp.add(j, num);
                    if (temp.size() == nums.length) {
                        result.add(new ArrayList<>(temp));
                    } else {
                        q.offer(new ArrayList<>(temp));
                    }
                }
            }
        }
        return result;
    }
}
