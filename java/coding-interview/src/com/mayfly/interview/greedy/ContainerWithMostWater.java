package com.mayfly.interview.greedy;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int currentArea = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println("maxArea = " + maxArea);
        return maxArea;
    }

    public void run() {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
    }
}
