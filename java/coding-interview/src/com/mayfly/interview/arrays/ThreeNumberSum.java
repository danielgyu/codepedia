package com.mayfly.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void run() {
        int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        List<Integer[]> ret = threeNumberSum(array, 0);
        System.out.println("ret = " + ret);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> ret = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int[] sliced = Arrays.copyOfRange(array, i, array.length);
            findTriplets(sliced, ret, targetSum);
        }
        return ret;
    }

    public static void findTriplets(int[] array, List<Integer[]> ret, int targetSum) {
        int fix = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            int firstAdd = fix + array[i];
            if (firstAdd > targetSum) {
                break;
            }

            for (int j = i + 1; j < array.length; j++) {
                int secondAdd = firstAdd + array[j];
                if (secondAdd == targetSum) {
                    System.out.println("fix = " + fix);
                    System.out.println("array[i] = " + array[i]);
                    System.out.println("array[j] = " + array[j]);
                    Integer[] triplet = new Integer[]{fix, array[i], array[j]};
                    ret.add(triplet);
                    System.out.println();
                } else if (secondAdd > targetSum){
                    break;
                }
            }
        }
    }
}
