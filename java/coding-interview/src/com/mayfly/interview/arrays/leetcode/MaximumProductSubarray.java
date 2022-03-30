package com.mayfly.interview.arrays.leetcode;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int[][] d = new int[nums.length][2];
        d[0][0] = nums[0];
        d[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            d[i][0] = Math.max(cur, Math.max(cur * d[i-1][0], cur * d[i-1][1]));
            d[i][1] = Math.min(cur, Math.min(cur * d[i-1][0], cur * d[i-1][1]));
        }
        System.out.println(Arrays.deepToString(d));

        int max = d[0][0];
        for (int i = 0; i < nums.length; i++)
            if (d[i][0]>max) max = d[i][0];
        return max;
    }

    public static void run() {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4, -8}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
