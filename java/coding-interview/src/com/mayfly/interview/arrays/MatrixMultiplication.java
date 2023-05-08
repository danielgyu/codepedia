package com.mayfly.interview.arrays;

import java.util.Arrays;

public class MatrixMultiplication {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12949

    public int[][] solution(int[][] arr1, int[][]arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        for (int[] row:result) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    result[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        System.out.println("Arrays.deepToString(result) = " + Arrays.deepToString(result));
        return result;
    }

    public void run() {
        int[][] left0 = {
                {1, 4},
                {3, 2},
                {4, 1},
        };
        int[][] right0 = {
                {3, 3},
                {3, 3}
        };
        solution(left0, right0);

        int[][] left1 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4},
        };
        int[][] right1 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };
        solution(left1, right1);
    }
}
