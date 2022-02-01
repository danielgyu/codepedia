package com.mayfly.interview.arrays;

public class LongestPeak {

    /*
     * [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
     */
    public static void run() {
        int[] array1 = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        longestPeak(array1);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 10, 100, 1000};
        longestPeak(array2);

        int[] array3 = new int[]{};
        longestPeak(array3);
    }

    public static int longestPeak(int[] array) {
        int longest = 0;
        int count = 1;
        int idx = 1;

        while (idx < array.length) {
            if (array[idx] > array[idx - 1]) {
                boolean increase = false;
                boolean decrease = false;

                while (idx < array.length && array[idx] > array[idx - 1]) {
                    increase = true;
                    count++;
                    idx++;
                }
                while (idx < array.length && array[idx] < array[idx - 1]) {
                    decrease = true;
                    count++;
                    idx++;
                }

                longest = increase && decrease ? Math.max(longest, count) : longest;
                count = 1;
            } else {
                idx++;
            }
        }

        System.out.println("longest = " + longest);
        return longest;
    }
}
