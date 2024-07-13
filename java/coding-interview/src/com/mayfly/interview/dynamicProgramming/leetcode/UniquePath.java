package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];

        // initialize the first row and first columns
        for (int col=0; col<n; col++) {
            board[0][col] = 1;
        }
        for (int row=0; row<m; row++) {
            board[row][0] = 1;
        }

        //System.out.println(Arrays.deepToString(board));

        // go over the rest
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                board[row][col] = board[row-1][col] + board[row][col-1];
            }
        }

        System.out.println("board[m-1][n-1] = " + board[m-1][n-1]);
        return board[m-1][n-1];
    }

    public void run() {
        uniquePaths(3, 2);
        uniquePaths(3, 7);
        uniquePaths(19, 13);
    }
}
