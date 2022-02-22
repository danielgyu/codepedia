package com.mayfly.interview.dynamicProgramming;

import java.util.Arrays;

public class MaxSubsetNoAdjacent {

    public static int maxSubsetNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        int[] maxSum = array.clone();
        maxSum[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + array[i]);
        }
        System.out.println(Arrays.toString(maxSum));
        return maxSum[array.length - 1];
    }

    public static void run() {
        int[] array1 = new int[]{75, 105, 120, 75, 90, 135};
        maxSubsetNoAdjacent(array1);

        int[] array2 = new int[]{};
        maxSubsetNoAdjacent(array2);

        int[] array3 = new int[]{1, 15, 3};
        maxSubsetNoAdjacent(array3);

        int[] array5 = new int[]{30, 25, 50, 55, 100};
        maxSubsetNoAdjacent(array5);

        int[] array4 = new int[]{4, 3, 5, 200, 5, 3};
        maxSubsetNoAdjacent(array4);
    }
}
