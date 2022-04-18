package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

public class HouseRobber {
    public static int solution2(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // [rob1, rob2, n, n+1, ...]
        for (int num : nums) {
            int temp = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
            System.out.println("rob1 = " + rob1);
            System.out.println("rob2 = " + rob2);
        }
        return rob2;
    }

    public static int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] ans = new int[nums.length];

        int maxNum = 0;
        int maxIdx = 0;
        for (int i = 0; i < 2; i++) {
            ans[i] = nums[i];
            if (ans[i] > maxNum) {
                maxNum = ans[i];
                maxIdx = i;
            }
        }

        for (int i = 2; i < ans.length; i++) {
            int bigger = Math.max(ans[i-1], nums[i] + ans[i-2]);
            if (i > maxIdx+1) {
                int newMaxNum = nums[i] + maxNum;
                ans[i] = Math.max(bigger, newMaxNum);
            } else {
                ans[i] = bigger;
            }
        }

        //System.out.println(Arrays.toString(ans));
        return ans[nums.length-1];
    }

    public static void run() {
        //System.out.println(solution2(new int[]{1, 2, 3, 1}));
        //System.out.println(solution2(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution2(new int[]{9, 1, 1, 9}));
        //System.out.println(solution2(new int[]{9, 1, 1, 9, 7, 3, 10}));
        //System.out.println(solution(new int[]{1}));
        //System.out.println(solution(new int[]{1, 2}));
        //System.out.println(solution(new int[]{1, 2, 3}));
    }
}
