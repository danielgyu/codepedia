package com.mayfly.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void run() {
        int[][] array1 = new int[][]{{1, 2}, {3, 5}, {4, 7}};
        mergeOverlappingIntervals(array1);

        int[][] array2 = new int[][]{{8, 10}, {7, 9}};
        mergeOverlappingIntervals(array2);
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(sortedIntervals[0]);

        int original = 1;
        int merged = 0;
        while (original < sortedIntervals.length) {
            if (sortedIntervals[original][1] <= res.get(merged)[1]) {
                original++;
                continue;
            } else if (sortedIntervals[original][0] <= res.get(merged)[1]) {
                res.get(merged)[1] = sortedIntervals[original][1];
            } else {
                res.add(sortedIntervals[original]);
                merged++;
            }
            original++;
        }

        for (int[] r : res) {
            System.out.println("r = " + Arrays.toString(r));
        }
        System.out.println();
        return res.toArray(new int[res.size()][]);
    }
}
