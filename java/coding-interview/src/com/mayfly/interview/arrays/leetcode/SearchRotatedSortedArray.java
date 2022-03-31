package com.mayfly.interview.arrays.leetcode;

public class SearchRotatedSortedArray {
    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // if mid element == target return
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                if (nums[left] < target || nums[right] > nums[mid]) {
                    right = mid - 1;
                } else if (nums[left] > target) {
                    left = mid + 1;
                }

            } else if (nums[mid] < target) {
                if (nums[left] < nums[mid] || nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void run() {
        System.out.println(solution(new int[]{4, 5, 6, 0, 1, 2, 3}, 1) + "==4");
        System.out.println(solution(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + "==4");
        System.out.println(solution(new int[]{4, 5, 6, 7, 0, 1, 2}, 5) + "==1");
        System.out.println(solution(new int[]{4, 5, 6, 7, 0, 1, 2}, 1) + "==5");
        System.out.println(solution(new int[]{4, 5, 6, 0, 1, 2, 3}, 4) + "==0");
        System.out.println(solution(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) + "==-1");
        System.out.println(solution(new int[]{1}, 0) + "==-1");
        System.out.println(solution(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8) + "==4");
        System.out.println(solution(new int[]{5, 1, 2, 3, 4}, 1) + "==1");
        System.out.println(solution(new int[]{8, 9, 2, 3, 4}, 9) + "==1");
    }
}