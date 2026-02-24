package com.leetcode.graphs;

import java.util.Arrays;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * <p>
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board.
 * Such regions are completely enclosed by 'X' cells.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board.
 * You do not need to return anything.
 */
public class SurroundedRegion {

    public static void main(String[] args) {
        SurroundedRegion surroundedRegion = new SurroundedRegion();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        surroundedRegion.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column) {
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] != 'O')
            return;
        board[row][column] = '#';
        dfs(board, row + 1, column);
        dfs(board, row - 1, column);
        dfs(board, row, column + 1);
        dfs(board, row, column - 1);

    }

}
