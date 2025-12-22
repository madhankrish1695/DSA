package com.leetcode.matrix;

import java.util.Arrays;

public class SetMatrixZeros {

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setMatrixZeros.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixZeros.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean isRowZero = false;
        boolean isColumnZero = false;

        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                isRowZero = true;
                break;
            }
        }

        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                isColumnZero = true;
                break;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < c; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < r; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (isRowZero) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }

        if (isColumnZero) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
