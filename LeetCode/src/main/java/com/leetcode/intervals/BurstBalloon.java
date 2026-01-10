package com.leetcode.intervals;

public class BurstBalloon {

    public static void main(String[] args) {
        BurstBalloon burstBalloon = new BurstBalloon();
        System.out.println(burstBalloon.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(burstBalloon.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(burstBalloon.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        int noOfArrows = 1;
        int currentLastPoint = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentLastPoint) {
                noOfArrows++;
                currentLastPoint = points[i][1];
            }
        }

        return noOfArrows;
    }
}
