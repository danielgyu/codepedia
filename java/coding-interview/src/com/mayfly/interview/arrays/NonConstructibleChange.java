package com.mayfly.interview.arrays;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class NonConstructibleChange {

    public void run() {
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};
        int res = nonConstructibleChange(coins);
        System.out.println("res = " + res);
    }

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int change = 0;
        for (int coin : coins) {
            if (coin > change + 1) {
                return change + 1;
            }
            change += coin;
        }
        return change + 1;
    }
}