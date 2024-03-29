package com.mayfly.interview.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) { // if sum is equal to 0
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left++], nums[right--])));
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                } else if (sum > 0) { // if bigger than 0
                    right--;
                } else { // if smaller than 0
                    left++;
                }
            }
        }

        return res;
    }

    public static void run() {
        System.out.println(solution(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(solution(new int[]{-2, 0, 2, 2}));
        System.out.println(solution(new int[]{}));
        System.out.println(solution(new int[]{0}));
    }
}
