package com.mayfly.interview.sortings;

import java.util.Arrays;

public class BubbleSort {
    public static void run() {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3}; // [2, 3, 5, 5, 6, 8, 9]
        bubbleSort(array);
        int[] array1 = new int[]{3, 2, 1}; // [2, 3, 5, 5, 6, 8, 9]
        bubbleSort(array1);
    }

    public static int [] bubbleSort(int[] array) {
        int loop = 0;
        while (loop < array.length - 1) {
            int left = 0;
            int right = 1;

            while (left < array.length - 1) {
                if (array[left] > array[right]) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }

                left++;
                right++;
            }

            loop++;
        }

        System.out.println("array = " + Arrays.toString(array));
        return array;
    }

}
