package com.mayfly.interview.dynamicProgramming;

import java.util.Arrays;

public class ProgrammersTriangle {

    public static int solution(int[][] triangle) {
        for (int row = 1; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                int diagonalLeft = (row-1 >= 0 && col-1 >= 0) ? triangle[row-1][col-1] : 0;
                int diagonalRight = (row-1 >= 0 && col < triangle[row-1].length) ? triangle[row-1][col] : 0;
                triangle[row][col] += Math.max(diagonalLeft, diagonalRight);
            }
        }

        int max = triangle[triangle.length-1][0];
        for (int i = 1; i < triangle[triangle.length-1].length; i++) {
            max = Math.max(max, triangle[triangle.length-1][i]);
        }
        return max;
    }

    public static void run() {
        System.out.println(solution(new int[][]{
            {7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}
        }));
    }
}
