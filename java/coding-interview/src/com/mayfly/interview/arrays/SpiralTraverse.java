package com.mayfly.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    /*
        [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]

     */

    public static void run() {
        /*
        int[][] array1 = new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        List<Integer> res1 = spiralTraverse(array1);
        System.out.println("res1 = " + res1);

        int[][] array2 = new int[][]{{1}};
        List<Integer> res2 = spiralTraverse(array2);
        System.out.println("res2 = " + res2);

        int[][] array3 = new int[][]{{1, 2}, {4, 3}};
        List<Integer> res3 = spiralTraverse(array3);
        System.out.println("res2 = " + res3);

        int[][] array4 = new int[][]{{1, 2}, {8, 3}, {7, 4}, {6, 5}};
        List<Integer> res4 = spiralTraverse(array4);
        System.out.println("res2 = " + res4);
         */

        int[][] array5 = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        List<Integer> res5 = spiralTraverse(array5);
        System.out.println("res5 = " + res5);
    }

    public static List<Integer> spiralTraverse(int[][] array) {

        ArrayList<Integer> traversed = new ArrayList<>();

        int position = 0;
        int curRow = 0;
        int round = 0;
        int rowLength = array[0].length;
        int columnLength = array.length;
        int total = rowLength * columnLength;

        while (traversed.size() < total){

            // traverse right
            while (traversed.size() < total && position < rowLength - round) {
                System.out.println("array[curRow][position] = " + array[curRow][position]);
                traversed.add(array[curRow][position]);
                position++;
            }
            position--;
            curRow++;

            // traverse down
            while (traversed.size() < total && curRow < columnLength - round) {
                traversed.add(array[curRow][position]);
                curRow++;
            }
            curRow--;
            position--;

            // traverse left
            while (traversed.size() < total && position >= 0 + round) {
                traversed.add(array[curRow][position]);
                position--;
            }
            position++;
            curRow--;

            //traverse up
            while (traversed.size() < total && curRow >= 0 +  round + 1) {
                traversed.add(array[curRow][position]);
                curRow--;
            }
            curRow++;
            position++;

            round++;
        }

        return traversed;
    }
}
