package com.mayfly.interview.arrays;

import java.util.*;

public class StarIntersection {
    public class Pair {
        public int x;
        public int y;
        public boolean isValid;

        public Pair(int x, int y, boolean isValid) {
            this.x = x;
            this.y = y;
            this.isValid = isValid;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", isValid=" + isValid +
                    '}';
        }
    }

    public Pair getIntersection(int[] l1, int[] l2) {
        int slope = ((l1[0]*l2[1]) - (l1[1]*l2[0]));
        if (slope == 0) {
            return new Pair(0, 0, false);
        }

        int x = ((l1[1]*l2[2]) - (l1[2]*l2[1])) / slope;
        int y = ((l1[2]*l2[0]) - (l1[0]*l2[2])) / slope;
        return new Pair(x, y, true);
    }

    public String[] solution(int[][] line) {
        // get all intersections
        Set<Pair> intersections = new HashSet<>();

        int k = 0;
        int up = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE,  left = Integer.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Pair pair = getIntersection(line[i], line[j]);
                if (pair.isValid) {
                    System.out.println("valid pair = " + pair);

                    intersections.add(pair);
                    up = Math.max(up, pair.y);
                    down = Math.min(down, pair.y);
                    left = Math.min(left, pair.x);
                    right = Math.max(right, pair.x);
                }
            }
        }

        // draw answer
        int vertical = Math.abs(down-up+1);
        int horizontal = Math.abs(left-right+1);
        String[] board = new String[down+up+1];
        int boardIdx = 0;

        for (int i = vertical; i < up+1; i++) {
            String row = "";
            for (int j = left; j < right+1; j++) {
                Pair pair = new Pair(i, j, true);
                if (intersections.contains(pair)) {
                    row += "*";
                } else {
                    row += ".";
                }
            }
            board[boardIdx++] = row;
        }

        System.out.println("up = " + up);
        System.out.println("down = " + down);
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("intersections = " + intersections);
        System.out.println("board = " + Arrays.toString(board));
        return board;
    }

    public void run() {
        int[][] line1 = new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 0, 1},
        };
        solution(line1);
    }

}
