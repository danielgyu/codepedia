package com.mayfly.interview.programmers.levelthree;

public class TwoXNTiles {

    public static int solution(int n) {
        int[] table = new int[n];
        table[0] = 1;
        table[1] = 2;
        for (int i = 2; i < n ; i++) {
            table[i] = (table[i-2] + table[i-1]) % 1000000007;
        }
        return table[n-1];
    }

    public static int solution2(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    public static void run() {
        System.out.println(solution(4));
        System.out.println(solution2(4));

        System.out.println(solution(16));
        System.out.println(solution2(16));
    }
}
