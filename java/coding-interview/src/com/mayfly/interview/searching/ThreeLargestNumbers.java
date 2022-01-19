package com.mayfly.interview.searching;

import java.util.Arrays;
import java.util.LinkedList;

public class ThreeLargestNumbers {
    private static int linkedListSize = 3;

    public static void run() {
        int[] array1 = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] result1 = findThreeLargestNumbers(array1);
        System.out.println(Arrays.toString(result1));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(Integer.MIN_VALUE);
        ll.add(Integer.MIN_VALUE);
        ll.add(Integer.MIN_VALUE);

        for (int i = 0; i < array.length; i++) {
            insertToArray(ll, array[i]);
        }

        int[] result = new int[linkedListSize];
        for (int i = 0; i < linkedListSize; i++) {
            Integer value = ll.removeLast();
            result[i] = value;
        }

        return result;
    }

    public static void insertToArray(LinkedList<Integer> ll, int inputValue) {
        for (int i = 0; i < linkedListSize; i++) {
            if (inputValue <= ll.get(i)) {
                continue;
            } else {
                ll.add(i, inputValue);
                ll.removeLast();
                break;
            }
        }
    }

}
