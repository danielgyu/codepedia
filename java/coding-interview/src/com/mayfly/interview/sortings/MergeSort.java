package com.mayfly.interview.sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIdx = 0;
        int rightIdx = 0;
        List<Integer> sorted = new ArrayList<>();

        while ((leftIdx+rightIdx) < (left.size()+right.size())) {
            // check out of bounds
            if (leftIdx >= left.size()) {
                sorted.add(right.get(rightIdx));
                ++rightIdx;
                continue;
            }
            if (rightIdx >= right.size()) {
                sorted.add(left.get(leftIdx));
                ++leftIdx;
                continue;
            }

            int leftValue = left.get(leftIdx);
            int rightValue = right.get(rightIdx);
            if (leftValue < rightValue) {
                sorted.add(leftValue);
                ++leftIdx;
            } else {
                sorted.add(rightValue);
                ++rightIdx;
            }
        }

        return sorted;
    }

    public List<Integer> sort(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums;
        }

        int mid = nums.size() / 2;
        List<Integer> left = sort(nums.subList(0, mid));
        List<Integer> right = sort(nums.subList(mid, nums.size()));

        return merge(left, right);
    }
    public void mergeSort(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().toList();
        List<Integer> merged = sort(numList);
        System.out.println("merged = " + merged);
    }

    public void run() {
        mergeSort(new int[]{7, 2, 5, 1, 3, 8, 7, 4, 9, 6});
        mergeSort(new int[]{8, 4, 1, 9, 6});
    }
}
