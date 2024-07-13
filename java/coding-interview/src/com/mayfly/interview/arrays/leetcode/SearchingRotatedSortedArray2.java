package com.mayfly.interview.arrays.leetcode;

public class SearchingRotatedSortedArray2 {
    public int getTranslatedMid(int left, int right, int rotated, int length) {
        int translatedLeft = ((left-rotated) % length + length) % length;
        int translatedRight = ((right-rotated) % length + length) % length;

        int mid = (translatedLeft + translatedRight) / 2;

        /*
        System.out.println(rotated);
        System.out.println(translatedLeft);
        System.out.println(translatedRight);
        System.out.println(mid);
        System.out.println((mid+rotated)%length);
         */

        return ((mid+rotated)%length);
    }
    public int search(int[] nums, int left, int right, int rotatedLength, int target) {
        // get middle
        int mid = getTranslatedMid(left, right, rotatedLength, nums.length);
        System.out.println("left="+left+" "+"right="+right+" "+"mid="+mid);

        if (nums[mid] == target) return mid;
        if (left == right || left >= nums.length) return -1;

        if (target < nums[mid]) {
            return search(nums, left, mid, rotatedLength, target);
        } else {
            return search(nums, (mid+1)%nums.length, right, rotatedLength, target);
        }
    }
    public int search(int[] nums, int target) {
        // get sorted version of left and right
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < min) {
                left = i;
                min = nums[i];
            }
        }

        int right = ((left-1) % nums.length + nums.length) % nums.length;
        return search(nums, left, right, left, target);
    }

    public void run() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(search(new int[]{1, 3}, 3)); // 1
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)); // 4
        System.out.println(search(new int[]{5, 1, 3}, 5)); // 0
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(search(new int[]{8, 9, 2, 3, 4}, 9)); // 1
        System.out.println(search(new int[]{1, 3}, 3)); // 1
        System.out.println(search(new int[]{1, 3}, 4)); // -1
    }
}
