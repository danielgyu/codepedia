package com.mayfly.interview.Searching;

import java.util.Iterator;
import java.util.LinkedList;

public class ThreeLargestNumbers {
    public static void run() {
        int[] array1 = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        LinkedList<Integer> ll = new LinkedList<>();
        insertToLinkedList(ll, array[0]);
        insertToLinkedList(ll, array[1]);
        insertToLinkedList(ll, array[2]);

        for (int i = 3; i < array.length - 3; i++) {
        }

        return new int[];
    }

    public static void insertToLinkedList(LinkedList<Integer> ll, int inputValue) {
        if (ll.isEmpty()) {
            ll.addLast(inputValue);
            return;
        }

        Iterator<Integer> iterator = ll.iterator();
        while (iterator.hasNext()) {
            int storedValue = iterator.next();
            if (inputValue > storedValue) {
            }
        }

    }
}
