package com.leetcode.graphs;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer
 * for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and
 * that there is no contradiction.
 * <p>
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 */
public class EvaluateDivision {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        EvaluateDivision solution = new EvaluateDivision();
        double[] result = solution.calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(result));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();

        //Construct graph
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            graph.putIfAbsent(first, new HashMap<>());
            graph.putIfAbsent(second, new HashMap<>());

            graph.get(first).put(second, values[i]);
            graph.get(second).put(first, 1.0 / values[i]);
        }

        //Find answers
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);

            if (!graph.containsKey(first) || !graph.containsKey(second)) {
                result[i] = -1.0;
            } else if (first.equals(second)) {
                result[i] = 1.0;
            } else {
                Set<String> visitedSet = new HashSet<>();
                result[i] = dfs(first, second, 1.0, visitedSet, graph);
            }

        }

        return result;
    }

    private double dfs(String current, String target, double multiplier, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (current.equals(target)) {
            return multiplier;
        }

        visited.add(current);
        for (Map.Entry<String, Double> entries : graph.get(current).entrySet()) {
            if (!visited.contains(entries.getKey())) {
                double val = dfs(entries.getKey(), target, multiplier * entries.getValue(), visited, graph);
                if (val != -1.0) {
                    return val;
                }
            }
        }

        return -1.0;
    }
}
