package com.mayfly.interview.sortings;

import java.util.Arrays;

public class QuickSort {
    public void print(int[] nums, int left, int right) {
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.out.println("left = " + left);
        System.out.println("right = " + right);
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int partition(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, left, i);
                left++;
            }
        }
        swap(nums, left, right);
        return left;
    }

    public void quickSortRecursive(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivot = partition(nums, left, right);

        quickSortRecursive(nums, left, pivot-1);
        quickSortRecursive(nums, pivot+1, right);
    }

    public void quickSort(int[] nums) {
        quickSortRecursive(nums, 0, nums.length-1);
        System.out.println("Final = " + Arrays.toString(nums));
    }

    public void run() {
        quickSort(new int[]{7, 2, 5, 1, 3, 8, 7, 4, 9, 6});
        quickSort(new int[]{8, 4, 1, 9, 6});
    }
}