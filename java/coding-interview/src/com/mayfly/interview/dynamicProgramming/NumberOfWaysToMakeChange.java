package com.mayfly.interview.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfWaysToMakeChange {
    /*
     * not using table[i+denom] because it can skip certain combinations
     * by counting the occurrence at table[i-denom], it is more certain
     */

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] table = new int[n+1];
        table[0] = 1;

        for (int denom : denoms) {
            for (int i = 1; i < n + 1; i++) {
                if (denom <= i) {
                    table[i] += table[i - denom];
                }
            }
        }
        System.out.println("table[n] = " + table[n]);
        return table[n];
    }

    public static void run() {
        numberOfWaysToMakeChange(6, new int[]{1, 5});
        numberOfWaysToMakeChange(7, new int[]{3, 4});
        numberOfWaysToMakeChange(10, new int[]{1, 5, 10, 25});
    }
}
