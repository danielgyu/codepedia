package com.mayfly.interview.dynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysToTraverseGraph {

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] table = new int[height][width];
        table[0][0] = 1;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (w-1 >= 0 && h-1 >= 0) table[h][w] = table[h-1][w] + table[h][w-1];
                else if (w-1 >= 0) table[h][w] = table[h][w-1];
                else if (h-1 >= 0) table[h][w] = table[h-1][w];
            }
        }

        for (int[] t : table) {
            System.out.println("Arrays.toString(t) = " + Arrays.toString(t));
        }
        System.out.println();
        return table[height-1][width-1];
    }

    public static void run() {
        numberOfWaysToTraverseGraph(2, 3);
        numberOfWaysToTraverseGraph(4, 3);
    }
}
