package com.mayfly.interview.graphs;

import java.util.Arrays;

public class RemoveIslands {
    static int TEMP = 0;
    static int VISITED = 1;
    static int NOT_VISITED = -1;

    static int rowStart = 0;
    static int colStart = 0;
    static int rowEnd;
    static int colEnd;

    public static int[][] solution(int[][] matrix) {
        rowEnd = matrix.length;
        colEnd = matrix[0].length;

        int[][] visited = new int[rowEnd][colEnd];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                visited[i][j] = NOT_VISITED;
            }
        }

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                checkAndRemove(matrix, visited, i, j);
                visited[i][j] = VISITED;
            }
        }

        return matrix;
    }

    public static void checkAndRemove(int[][] matrix, int[][] visited, int row, int col) {
        System.out.println("entering " + row + " " + col);
        if (matrix[row][col] == 1 && checkIsland(matrix, visited, row, col)) {
            removeIsland(matrix, visited, row, col);
        }
        System.out.println();
    }

    public static void removeIsland(int[][] matrix, int[][] visited, int row, int col) {
        if (matrix[row][col] == 0) {
            return;
        }
        System.out.println("removing " + row + " " + col);
        matrix[row][col] = 0;

        if (row > 0) removeIsland(matrix, visited, row-1, col);
        if (row+1 < rowEnd) removeIsland(matrix, visited, row+1, col);
        if (col > 0) removeIsland(matrix, visited, row, col-1);
        if (col+1 < colEnd) removeIsland(matrix, visited, row, col+1);
    }

    public static boolean checkIsland(int[][] matrix, int[][] visited, int row, int col) {
        System.out.println("checking " + row + " " + col + " = " + matrix[row][col] + ", visited = " + visited[row][col]);
        if (row == 0 || row == rowEnd-1 || col == 0 || col == colEnd-1) {
            if (matrix[row][col] == 1) return false;
        }

        if (matrix[row][col] == 0) return true;
        if (visited[row][col] == VISITED) return false;
        if (visited[row][col] == TEMP) return true;
        visited[row][col] = TEMP;

        if (matrix[row][col] == 1) {
            if (!checkIsland(matrix, visited, row-1, col)) {
                visited[row][col] = NOT_VISITED;
                return false;
            }
            if (!checkIsland(matrix, visited, row+1, col)) {
                visited[row][col] = NOT_VISITED;
                return false;
            }
            if (!checkIsland(matrix, visited, row, col-1)) {
                visited[row][col] = NOT_VISITED;
                return false;
            }
            if (!checkIsland(matrix, visited, row, col+1)) {
                visited[row][col] = NOT_VISITED;
                return false;
            }
        }
        System.out.println("check complete");
        visited[row][col] = NOT_VISITED;

        return true;
    }

    public static void run() {
        int[][] res1 = solution(new int[][]{
                {0, 0, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}

        });
        for (int i = 0; i < res1.length; i++) {
            System.out.println(Arrays.toString(res1[i]));
        }

        int[][]res2 = solution(new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        });
        for (int i = 0; i < res2.length; i++) {
            System.out.println(Arrays.toString(res2[i]));
        }
    }
}
