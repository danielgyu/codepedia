package com.mayfly.interview.arrays;

import java.util.Arrays;

public class ArrayofProducts {

    public static void run() {
        int[] array1 = new int[]{5, 1, 4, 2};
        arrayOfProducts(array1);

        int[] array3 = new int[]{4, 4};
        arrayOfProducts(array3);

        int[] array4 = new int[]{0, 0, 0};
        arrayOfProducts(array4);

        int[] array2 = new int[]{-5, 2, -4, 14, -6};
        arrayOfProducts(array2);
    }

    public static int[] arrayOfProducts(int[] array) {
        int[] res = new int[array.length];
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        int leftCount = 1;
        for (int i = 1; i < array.length; i++) {
            leftCount *= array[i-1];
            left[i] = leftCount;
        }
        int rightCount = 1;
        for (int i = array.length - 2; i > -1; i--) {
            rightCount *= array[i+1];
            right[i] = rightCount;
        }

        for (int i = 0; i < array.length; i++) {
            res[i] = left[i] * right[i];
        }

        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
        return res;
    }
}
