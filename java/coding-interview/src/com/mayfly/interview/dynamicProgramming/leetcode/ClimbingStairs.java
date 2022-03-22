package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/climbing-stairs/
 * difficulty medium
 */
public class ClimbingStairs {

    public static int solution(int n) {
        if (n <= 2) return n;

        int[] table = new int[n+1];
        table[1] = 1;
        table[2] = 2;

        for (int i = 3; i < n+1; i++) {
            table[i] = table[i-1] + table[i-2];
        }
        System.out.println("Arrays.toString(table) = " + Arrays.toString(table));

        return table[n];
    }

    public static void run() {
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
