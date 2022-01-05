package com.mayfly.interview.arrays;

import java.util.SortedSet;
import java.util.TreeSet;

public class NonConstructibleChange {

    public void run() {
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};
        int res = nonConstructibleChange(coins);
        System.out.println("res = " + res);
    }

    public int nonConstructibleChange(int[] coins) {
        if (coins.length == 0) {
            return 1;
        }

        SortedSet<Integer> changeSet = new TreeSet<>();

        for (int i = 0; i < coins.length - 1; i++) {
            int currentChange = coins[i];
            changeSet.add(currentChange);

            for (int j = i + 1; j < coins.length; j++) {
                currentChange += coins[j];
                changeSet.add(currentChange);
            }
        }

        System.out.println("changeSet = " + changeSet);

        for (int s = 1; s < changeSet.size(); s++) {
            if (!changeSet.contains(s)) {
                return s;
            }
        }

        return -1;
    }
}
