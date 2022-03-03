package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiverSizes {
    static int row;
    static int col;

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int size = bfs(matrix, i, j, 1);
                    res.add(size);
                }
            }
        }

        System.out.println("res = " + res);
        return res;
    }

    public static int bfs(int[][] matrix, int i, int j, int size) {
        if (matrix[i][j] != 1) {
            return 0;
        }

        matrix[i][j] = 0;
        // up: i-1
        if (i > 0)  size += bfs(matrix, i - 1, j, 1);
        // down: i+1
        if (i < row - 1) size += bfs(matrix, i + 1, j, 1);
        // left: j-1
        if (j > 0) size += bfs(matrix, i, j - 1, 1);
        // right: j+1
        if (j < col - 1) size += bfs(matrix, i, j + 1, 1);

        return size;
    }

    public static void run() {
        /*
        riverSizes(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
         */
        riverSizes(new int[][]{
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        });
        /*
        riverSizes(new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        });
        */
    }
}
