package com.mayfly.interview.recursion;

import java.util.Arrays;

public class QuadCompression {
    private final int[] result = new int[] {0, 0};

    public int[] solution(int[][] arr) {
        compress(0, 0, arr.length, arr);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        return result;
    }

    public boolean canCompress(int offsetX, int offsetY, int size, int[][] arr) {
        /*
         * 현재의 사각형(=arr[offsetY][offsetX] 부터 size만큼)이 같은 숫자를 가지고 있는지 확인
         * 모두 같은 숫자일 경우 compress 가능
         */

        int target = arr[offsetY][offsetX];

        for (int y = offsetY; y < offsetY + size; y++) {
            for (int x = offsetX; x < offsetX + size; x++) {
                if (target != arr[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void compress(int offsetX, int offsetY, int size, int[][] arr) {
        // 사이즈가 1일 경우 -> 가장 작은 단위이기 때문에 반환
        // canCompress일 경우 -> 압축 가능하기 때문에 반환
        if (size == 1 || canCompress(offsetX, offsetY, size, arr)) {
            int num = arr[offsetY][offsetX];
            result[num] += 1;
        // 사이즈가1도 아니고 압축도 안될 경우 -> 사각형을 4조각으로 쪼깸
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
