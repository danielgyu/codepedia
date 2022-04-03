package com.mayfly.interview.programmers.levelthree;

import java.util.Arrays;

public class Ranking {
    public static int solution(int n, int[][] results) {
        int[][] table = new int[n+1][n+1];

        int INF = n * n + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = INF;
            }
            table[i][i] = 0;
        }

        for (int i = 0; i < results.length; i++) {
            table[results[i][0]][results[i][1]] = 1;
            //int A = results[i][0];
            //int B = results[i][1];
            //table[A][B] = 1;
            //table[B][A] = -1;
        }
        System.out.println("first");
        print(table);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (table[j][k] > table[j][i] + table[i][k]) {
                        table[j][k] = table[j][i] + table[i][k];
                    }
                }
            }
        }

        System.out.println("second");
        print(table);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 0; j <= n; j++) {
                if (i != j && table[i][j] == INF && table[j][i] == INF) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        return answer;
    }

    public static void run() {
        System.out.println(solution(5, new int[][]{
                {4,3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        }));
    }

    public static void print(int[][] table) {
        for (int[] t : table) {
            System.out.println(Arrays.toString(t));
        }

    }
}
