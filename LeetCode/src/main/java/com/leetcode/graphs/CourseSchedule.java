package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
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

        System.out.println("Can finish all courses: " + courseSchedule.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int completed = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

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

            for (int preReq : graph.get(current)) {
                inDegree[preReq]--;
                if (inDegree[preReq] == 0) {
                    q.offer(preReq);
                }
            }

        }
        return completed == numCourses;
    }
}
