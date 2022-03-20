package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPassesOfMatrix {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkAllPositive(int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < 0) return false;
            }
        }
        return true;
    }

    public static int solution(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // check how many passes are needed
        int passes = 0;
        while (true) {
            if (checkAllPositive(rows, columns, matrix)) break;

            boolean allPositive = true;
            boolean changed = false;
            List<Pair> changes = new ArrayList<>();

            // loop over each element
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] < 0) {
                        allPositive = false;

                        if ((i > 0 && matrix[i-1][j] > 0) ||
                                (i < rows-1 && matrix[i+1][j] > 0) ||
                                (j > 0 && matrix[i][j-1] > 0) ||
                                (j < columns-1 && matrix[i][j+1] > 0)
                        ) {
                            changed = true;
                            changes.add(new Pair(i, j));
                        }
                    }
                }
            }
            for (Pair ch : changes) {
                matrix[ch.x][ch.y] *= -1;
            }


            // if all elements are positive, break
            passes++;
            if (!allPositive && !changed) return -1;

            /*
            for (int[] m : matrix) {
                System.out.println(Arrays.toString(m));
            }
            System.out.println();
             */
        }

        return passes;
    }

    public static void run() {
        System.out.println(solution(new int[][]{
                {0, -2, -1},
                {-5, 2, 0},
                {-6, -2, 0}
        })); //2

        System.out.println(solution(new int[][]{
                {0, -1, -3, 2, 0},
                {1, -2, -5, -1, -3},
                {3, 0, 0, -4, -1}
        })); //3

        System.out.println(solution(new int[][]{
                {1},
        })); // 0

        System.out.println(solution(new int[][]{
                {1, 0, 0, -2, -3},
                {-4, -5, -6, -2, -1},
                {0, 0, 0, 0, -1},
                {1, 2, 3, 0, -2}
        }));
    }
}
