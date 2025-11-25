package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] rd = new int[]{0, 1, 0, -1};
        int[] cd = new int[]{1, 0, -1, 0};

        int r = 0, c = 0, k = 0, d = 0;

        while (k < n * m) {
            resultList.add(matrix[r][c]);
            visited[r][c] = true;

            int nr = r + rd[d];
            int nc = c + cd[d];

            if (nr >= n || nc >= m || nr < 0 || nc < 0 || visited[nr][nc]) {
                d = (d + 1) % 4;
            }

            r = r + rd[d];
            c = c + cd[d];
            k++;
        }

        return resultList;
    }
}
