package com.mayfly.interview.arrays.leetcode;

public class MinimumInRotatedSortedArray {
    public static int solution(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            //System.out.println("mid = " + mid);
            answer = Math.min(answer, nums[mid]);

            if (nums[mid] > nums[right]) { // mid is bigger than right
                left = mid+1;
            } else if (nums[mid] < nums[left]) { // mid is smaller
                right = mid-1;
            } else { // sorted
                right = mid-1;
            }

        }

        return answer;
    }

    public static void run() {
        System.out.println(solution(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution(new int[]{11, 13, 15, 17}));
        System.out.println(solution(new int[]{11, 12, 13, 14, 15, 16, 0, 1, 2, 3, 4}));
    }
}