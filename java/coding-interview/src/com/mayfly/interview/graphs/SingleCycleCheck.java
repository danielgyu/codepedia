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

        return curIndex == 0;
    }

    public static int findNextIndex(int givenIndex, int[] array) {
        int value = array[givenIndex];
        int nextIndex = (givenIndex + value) % array.length;

        System.out.println("givenIndex: " + givenIndex + " " + "value: " + value);
        System.out.println("nextIndex = " + nextIndex);
        System.out.println();
        return nextIndex;
    }

    public static void run() {
        singleCycleCheck(new int[]{2, 3, 1, -4, -4, 2});
    }
}
