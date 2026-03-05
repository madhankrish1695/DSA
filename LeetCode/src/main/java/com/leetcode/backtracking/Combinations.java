package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations solution = new Combinations();

        int n = 4;
        int k = 2;

        List<List<Integer>> result = solution.combine(n, k);

        System.out.println("n = " + n + ", k = " + k);
        System.out.println("Combinations:");
        System.out.println(result);
        System.out.println(solution.combineBfs(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int start, int n, int k, List<Integer> digit, List<List<Integer>> result) {
        if (digit.size() == k) {
            result.add(new ArrayList<>(digit));
            return;
        }

        for (int i = start; i <= n; i++) {
            digit.add(i);
            dfs(i + 1, n, k, digit, result);
            digit.remove(digit.size() - 1);
        }
    }

    public List<List<Integer>> combineBfs(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());

        while (!q.isEmpty()) {
            List<Integer> cur = q.poll();
            if (cur.size() == k) {
                result.add(cur);
                continue;
            }
            int start = cur.isEmpty() ? 1 : cur.get(cur.size() - 1) + 1;

            for (int i = start; i <= n; i++) {
                List<Integer> next = new ArrayList<>(cur);
                next.add(i);
                q.offer(next);
            }
        }
        return result;
    }
}
