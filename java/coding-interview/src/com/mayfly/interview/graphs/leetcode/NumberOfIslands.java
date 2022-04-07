package com.mayfly.interview.graphs.leetcode;

public class NumberOfIslands {
    static int rows;
    static int cols;

    public static int solution(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    bfs(grid, i, j);
                }
            }
        }
        return answer;
    }

    public static void bfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        // up
        if (i > 0) bfs(grid, i-1, j);
        // down
        if (i < rows-1) bfs(grid, i+1, j);
        // left
        if (j > 0) bfs(grid, i, j-1);
        // right
        if (j < cols-1) bfs(grid, i, j+1);
    }


    public static void run() {
        System.out.println(solution(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        System.out.println(solution(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
