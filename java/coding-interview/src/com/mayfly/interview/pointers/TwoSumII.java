package com.mayfly.interview.pointers;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                int[] res = new int[]{left+1, right+1};
                System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
                return res;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public void run() {
        twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum(new int[]{2,3,4}, 6);
        twoSum(new int[]{-1,0}, -1);
    }
}
