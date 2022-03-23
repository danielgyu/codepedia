package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int solution(String text1, String text2) {
        int[][] table = new int[text2.length()][text1.length()];

        for (int i = 0; i < text2.length(); i++) {
            for (int j = 0; j < text1.length(); j++) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    // carry from diagonal row + 1
                    if (i > 0 && j > 0) table[i][j] = table[i-1][j-1] + 1;
                    // else just = 1
                    else table[i][j] = 1;
                } else {
                    int left = 0, up = 0;
                    if (j > 0) left = table[i][j-1];
                    if (i > 0) up = table[i-1][j];
                    table[i][j] = Math.max(left, up);
                }
            }
        }

        //printTable(table);
        return table[text2.length()-1][text1.length()-1];
    }

    public static void printTable(int[][] table) {
        for (int[] t : table) {
            System.out.println(Arrays.toString(t));
        }
    }

    public static void run() {
        //System.out.println(solution("abcde", "ace")); //3
        //System.out.println(solution("cdfed", "zxdye")); //2
        System.out.println(solution("abcba", "abcbcba")); //5
        System.out.println(solution("pmjghexybyrgzczy", "hafcdqbgncrcbihkd")); //4
    }
}
