package com.mayfly.interview.graphs;

public class SingleCycleCheck {

    public static boolean singleCycleCheck(int[] array) {
        int curIndex = 0;
        int numVisited = 0;

        while (numVisited < array.length) {
            if (numVisited > 0 && curIndex == 0) return false;
            curIndex = findNextIndex(curIndex, array);

            numVisited++;
        }

        System.out.println("curIndex == 0 = " + (curIndex == 0));
        return curIndex == 0;
    }

    public static int findNextIndex(int givenIndex, int[] array) {
        int value = array[givenIndex];
        int nextIndex = (givenIndex + value);
        int mod = nextIndex > 0 ? nextIndex % array.length : Math.floorMod(nextIndex, array.length);

        return mod;
    }

    public static void run() {
        singleCycleCheck(new int[]{2, 3, 1, -4, -4, 2});
    }
}
