package com.mayfly.interview.sortings;

import java.util.Arrays;

public class InsertionSort {
    public static void run() {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] result = insertionSort(array);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] insertionSort(int[] array) {
        int index = 1;
        while (index < array.length) {
            int right = index;
            int left = index - 1;


            while (left >= 0 && array[right] < array[left]) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;

                right--;
                left--;
            }

            index++;
        }

        return array;
    }
}
