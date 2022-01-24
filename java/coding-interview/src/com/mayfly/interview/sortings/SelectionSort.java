package com.mayfly.interview.sortings;

import java.util.Arrays;

// loop over each array
// find if the array contains a number smaller than itself
// O(N^2)
public class SelectionSort {

    public static void run() {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        System.out.println("array = " + Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            int currentMin = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < currentMin) {
                    currentMin = array[j];
                    minIndex = j;
                }
            }

            if (currentMin < array[i]) {
                int temp = array[i];
                array[i] = currentMin;
                array[minIndex] = temp;
            }
        }

        return array;
    }
}
