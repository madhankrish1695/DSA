package com.leetcode.graphBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 * <p>
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 * <p>
 * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
 * This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
 * If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
 * The game ends when you reach the square n2.
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.
 * <p>
 * Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
 * <p>
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 * Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1.
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        SnakesAndLadders solution = new SnakesAndLadders();
        int result = solution.snakesAndLadders(board);

        System.out.println("Minimum dice rolls: " + result);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); // {Current position, total moves}
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int position = current[0];
            int move = current[1];

            for (int next = position + 1; next <= Math.min(position + 6, n * n); next++) {
                int[] coOrderdinates = getCoorderdinates(next, n);
                int destination = board[coOrderdinates[0]][coOrderdinates[1]] == -1 ? next : board[coOrderdinates[0]][coOrderdinates[1]];
                if (!visited[destination]) {
                    if (next == n * n) return move + 1;
                    q.offer(new int[]{destination, move + 1});
                    visited[destination] = true;
                }
            }
        }

        return -1;
    }

    private int[] getCoorderdinates(int position, int n) {
        int rowFromBottom = (position - 1) / n;
        int row = n - 1 - rowFromBottom;
        int column = (position - 1) % n;
        if (rowFromBottom % 2 == 1) column = n - 1 - column;
        return new int[]{row, column};
    }
}
