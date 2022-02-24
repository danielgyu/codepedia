package com.mayfly.interview.dynamicProgramming;

import java.util.Arrays;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] table = initializeTable(str1.length()+1, str2.length()+1);

        for (int i = 1; i < str2.length()+1; i++) {
            for (int j = 1; j < str1.length()+1; j++) {
                if (str1.charAt(j-1) == str2.charAt(i-1)) {
                    table[i][j] = table[i-1][j-1];
                } else {
                    table[i][j] = Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j - 1])) + 1;
                }
            }
        }

        for (int[] t : table) {
            System.out.println("Arrays.toString(t) = " + Arrays.toString(t));
        }
        
        return table[str2.length()][str1.length()];
    }

    public static int[][] initializeTable(int columns, int rows) {
        int[][] table = new int[rows][columns];
        for (int i = 0; i < columns; i++) {
            table[0][i] = i;
        }

        for (int i = 1; i < rows; i++) {
            table[i][0] = i;
        }

        return table;
    }

    public static void run() {
        levenshteinDistance("abcdef", "azced");
        levenshteinDistance("abc", "yabd");
    }
}
