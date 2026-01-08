package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{4, 7}, {1, 4}})));
    }

    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int size = resultList.size();
            if (size == 0 || resultList.get(size - 1)[1] < intervals[i][0]) {
                int[] intervalList = new int[2];
                intervalList[0] = intervals[i][0];
                intervalList[1] = intervals[i][1];
                resultList.add(intervalList);
            } else {
                resultList.get(size - 1)[1] = Math.max(resultList.get(size - 1)[1], intervals[i][1]);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
