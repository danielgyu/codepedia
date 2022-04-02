package com.mayfly.interview.arrays.leetcode;

public class ContainerWithMostWater {
    public static int solution(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while (left < right) {
            int size = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, size);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

    public static void run() {
        System.out.println(solution(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution(new int[]{1, 1}));
    }
}
