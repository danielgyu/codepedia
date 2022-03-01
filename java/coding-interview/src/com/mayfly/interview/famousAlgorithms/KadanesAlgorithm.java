package com.mayfly.interview.famousAlgorithms;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int curSum = array[0];
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++) {
            curSum = Math.max(array[i], curSum + array[i]);
            maxSum = Math.max(curSum, maxSum);
        }

        System.out.println("maxSum = " + maxSum);
        return maxSum;
    }

    public static void run() {
        kadanesAlgorithm(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4});
    }
}
