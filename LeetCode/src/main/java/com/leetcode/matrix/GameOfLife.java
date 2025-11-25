package com.leetcode.matrix;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int oneCount = 0;

                for (int k = 0; k < dir.length; k++) {
                    int row = i + dir[k][0];
                    int col = j + dir[k][1];
                    if (row < board.length && row >= 0 && col < board[0].length && col >= 0 && (board[row][col] == 1 || board[row][col] == -1)) {
                        oneCount++;
                    }
                }

                if (board[i][j] == 1 && oneCount < 2) board[i][j] = -1;
                if (board[i][j] == 1 && (oneCount == 2 || oneCount == 3)) board[i][j] = 1;
                if (board[i][j] == 1 && oneCount > 3) board[i][j] = -1;
                if (board[i][j] == 0 && oneCount == 3) board[i][j] = 2;
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}
