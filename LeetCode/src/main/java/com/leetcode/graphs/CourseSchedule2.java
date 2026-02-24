package com.leetcode.graphs;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int numCourses = 8;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
                {4, 3},
                {5, 3},
                {6, 4},
                {6, 5},
                {7, 6}
        };
        //0 → 1 → 3 → 4 → 6 → 7
        //  ↘ 2 ↗      ↘ 5 ↗

        System.out.println("Can finish all courses: " + Arrays.toString(courseSchedule2.findOrder(numCourses, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int completed = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        List<Integer> orderList = new ArrayList<>();

        //form graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            graph.get(preReq).add(course);
            inDegree[course]++;
        }

        //add course with no prerequisite to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            completed++;
            orderList.add(current);

            for (int preReq : graph.get(current)) {
                inDegree[preReq]--;
                if (inDegree[preReq] == 0) {
                    q.offer(preReq);
                }
            }

        }

        if (completed == numCourses) {
            return orderList.stream().mapToInt(Integer::intValue).toArray();
        }

        return new int[0];
    }
}
