package com.mayfly.interview.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void run() {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        moveElementToEnd(array, 2);

        List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
        moveElementToEnd(array2, 3);

        List<Integer> array3 = Arrays.asList(1, 2, 4, 3, 5);
        moveElementToEnd(array3, 3);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;
        int end = array.size() - 1;

        while (left <= right) {
            if (array.get(left) == toMove) {
                int tempEnd = end;
                while (array.get(tempEnd) == toMove && left < tempEnd) {
                    tempEnd--;
                }
                int temp = array.get(tempEnd);
                array.set(tempEnd, array.get(left));
                array.set(left, temp);
                right--;
            }

            left++;
        }

        System.out.println("array = " + array);
        return array;
    }
}
