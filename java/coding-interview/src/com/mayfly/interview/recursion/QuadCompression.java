package com.mayfly.interview.recursion;

public class QuadCompression {
    private final int[] result = new int[] {0, 0};

    public int[] solution(int[][] arr) {
        compress(0, 0, arr.length, arr);
        return result;
    }

    public void compress(int offsetX, int offsetY, int size, int[][] arr) {
        if (size == 1) {
            int num = arr[offsetY][offsetX];
            result[num] += 1;
        } else {
            size /= 2;
            // upper left
            compress(offsetX, offsetY, size, arr);
            // upper right
            compress(offsetX+size, offsetY, size, arr);
            // lower left
            compress(offsetX, offsetY+size, size, arr);
            // lower right
            compress(offsetX+size, offsetY+size, size, arr);
        }
    }

    public void run() {
        solution(new int[][] {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        });
    }
}
