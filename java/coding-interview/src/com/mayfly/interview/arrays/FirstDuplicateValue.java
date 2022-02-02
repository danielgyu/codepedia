package com.mayfly.interview.arrays;

public class FirstDuplicateValue {

    public static void run() {
        int[] array1 = new int[]{2, 1, 5, 2, 3, 3, 4};
        firstDuplicateValue(array1);

        int[] array2 = new int[]{8, 20, 4, 12, 14, 9, 19, 17, 14, 20, 22, 9, 6, 15, 1, 15, 10, 9, 17, 7, 22, 17};
        firstDuplicateValue(array2);
    }

    public static int firstDuplicateValue(int[] array) {
        int[] res = new int[array.length+1];
        for (int num : array) {
            if (res[num] != 0) {
                System.out.println("num = " + num);
                return num;
            }
            res[num] += 1;
        }
        System.out.println("-1");
        return -1;
    }
}
