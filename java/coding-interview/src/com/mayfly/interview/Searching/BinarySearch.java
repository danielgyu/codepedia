package com.mayfly.interview.Searching;

public class BinarySearch {
    public static void run() {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int index = binarySearch(array, 33);
        System.out.println("index = " + index);

        int[] array2 = new int[]{1, 5, 23, 111};
        int index2 = binarySearch(array2, 111);
        System.out.println("index = " + index2);

        int[] array3 = new int[]{1, 5, 23, 111};
        int index3 = binarySearch(array3, 135);
        System.out.println("index = " + index3);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        return search(left, right, array, target);
    }

    public static int search(int left, int right, int[]array, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (target == array[mid]) {
            return mid;
        } else if (target < array[mid]) {
            return search(left, mid - 1, array, target);
        } else {
            return search(mid + 1, right, array, target);
        }
    }
}
