package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

public class CoinChange {

    public static int solution(int[] coins, int amount) {
        int[] table = new int[amount+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int denom : coins) {
            for (int i = 0; i < table.length; i++) {
                if (i >= denom && table[i-denom] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[i-denom]+1);
                }
            }
        }

        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
    }

    public static void run() {
        System.out.println(solution(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(solution(new int[]{1, 2, 5}, 3)); // 2
        System.out.println(solution(new int[]{2}, 3)); // -1
        System.out.println(solution(new int[]{1, 5, 10}, 7)); // 3
        System.out.println(solution(new int[]{1}, 0)); // 0
        System.out.println(solution(new int[]{186, 419, 83, 408}, 6249)); // 20
    }
}
