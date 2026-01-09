package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || intervals.length == 0) return new int[0][0];

        List<int[]> resultList = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals less than new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            resultList.add(intervals[i]);
            i++;
        }

        //merge interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        resultList.add(newInterval);

        // add remaining
        while (i < n) {
            resultList.add(intervals[i]);
            i++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
