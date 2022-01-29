package com.mayfly.interview.arrays;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class SmallestDifference {

    public static void run() {
        /*
        int[] one = new int[]{-1, 5, 10, 20, 28, 3};
        int[] two = new int[]{26, 134, 135, 15, 17};
        int[] ret = smallestDifference(one, two);
        System.out.println("ret = " + Arrays.toString(ret));
         */

        int[] one1 = new int[]{240, 124, 86, 111, 2, 84, 954, 27, 89};
        int[] two1 = new int[]{1, 3, 954, 19, 8};
        int[] ret2 = smallestDifference(one1, two1);
        System.out.println("ret2 = " + Arrays.toString(ret2));

    }

    public static int[] smallestDifference(int[] one, int[] two) {
        Arrays.sort(one);
        Arrays.sort(two);

        int[] ret = new int[]{};
        for (int o : one) {
            int[] smallest = findSmallestPair(o, two);
            ret = findMinimumPair(smallest, ret);
        }

        return ret;
    }

    public static int[] findSmallestPair(int o, int[] two) {
        int[] smallestPair = new int[2];
        int smallest = Integer.MAX_VALUE;

        for (int t: two) {
            int curDiff = Math.abs(o - t);
            if (curDiff < smallest) {
                smallest = curDiff;
                smallestPair[0] = o;
                smallestPair[1] = t;
            } else {
                break;
            }
        }

        return smallestPair;
    }

    public static int[] findMinimumPair(int[] smallest, int[] ret) {
        System.out.println("smallest = " + Arrays.toString(smallest));
        System.out.println("ret = " + Arrays.toString(ret));
        if (ret.length == 0) {
            return smallest;
        } else if (Math.abs(smallest[0] - smallest[1]) < Math.abs(ret[0] -  ret[1])) {
            return smallest;
        } else {
            return ret;
        }
    }
}
