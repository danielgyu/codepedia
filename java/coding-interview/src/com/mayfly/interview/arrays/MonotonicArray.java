package com.mayfly.interview.arrays;

public class MonotonicArray {
    static String up = "up";
    static String down = "down";
    static String same = "same";

    public static void run() {
        int[] array1 = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println("isMonotonic() = " + isMonotonic(array1));

        int[] array2 = new int[]{};
        System.out.println("isMonotonic() = " + isMonotonic(array2));

        int[] array3 = new int[]{1};
        System.out.println("isMonotonic() = " + isMonotonic(array3));

        int[] array4 = new int[]{1, 2, 0};
        System.out.println("isMonotonic() = " + isMonotonic(array4));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return true;
        }

        String direction = getMonotonicDirection(array);
        System.out.println("direction = " + direction);
        if (direction == same) { return true; }
        return determineIsMonotonic(array, direction);
    }

    public static boolean determineIsMonotonic(int[] array, String direction) {
        for (int i = 0; i < array.length - 1; i++) {
            if (direction == up && array[i] > array[i+1]) {
                return false;
            } else  if (direction == down && array[i] < array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static String getMonotonicDirection(int[] array) {
        int base = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[0] != array[i]) {
                return (array[i] > array[0]) ? up : down;
            }
        }
        return same;
    }
}
