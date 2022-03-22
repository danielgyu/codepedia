package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int solution(int[] nums) {
        int[] table = new int[nums.length];
        Arrays.fill(table, 1);

        for (int i = 1; i < nums.length; i++) {
            int biggest = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    biggest = Math.max(biggest, table[j]);
                }
            }
            table[i] = biggest + 1;
        }

        return Arrays.stream(table).max().getAsInt();
    }

    public static void run() {
        System.out.println(solution(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution(new int[]{0,1,0,3,2,3}));
        System.out.println(solution(new int[]{7, 7, 7, 7, 7, 7}));
    }
}
