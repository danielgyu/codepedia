package com.mayfly.interview.dynamicProgramming;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int denom : denoms) {
            for (int i = 0; i < n + 1; i++) {
                if (denom <= i && table[i - denom] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[i - denom] + 1);
                }
            }
        }

        return table[n] != Integer.MAX_VALUE ? table[n] : -1;
    }

    public static void run() {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1, 5, 10}));
        System.out.println(minNumberOfCoinsForChange(4, new int[]{1, 5, 10}));
        System.out.println(minNumberOfCoinsForChange(10, new int[]{1, 5, 10}));
        System.out.println(minNumberOfCoinsForChange(3, new int[]{2, 1}));
    }
}
