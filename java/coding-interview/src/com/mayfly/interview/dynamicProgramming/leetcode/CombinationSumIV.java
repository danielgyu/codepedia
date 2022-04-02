package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.*;

public class CombinationSumIV {
    static Map<Integer, Integer> map = new HashMap<>();

    public static int solution(int[] nums, int target) {
        int answer = 0;
        if (map.containsKey(target)) return map.get(target);
        if (target == 0) return 1;
        if (target < 0) return 0;

        for (int num : nums) {
            answer += solution(nums, target-num);
        }

        map.put(target, answer);
        return answer;
    }

    public static int bottomUp(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static void run() {
        //System.out.println(solution(new int[]{1, 2, 3}, 4));
        //System.out.println(solution(new int[]{9}, 3));
        System.out.println(bottomUp(new int[]{1, 2, 3}, 4));
    }
}
