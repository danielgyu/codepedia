package com.mayfly.interview.sortings;

import java.util.Arrays;
import java.util.Collections;

public class ProgrammersSorting {

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void run() {
        System.out.println(solution(new int[]{10, 8, 5, 4, 3})); //4
        System.out.println(solution(new int[]{10, 10, 10, 10, 10})); //#9 5
        System.out.println(solution(new int[]{5, 5, 5, 5})); //4
        System.out.println(solution(new int[]{0, 0, 0, 0, 0})); //#16 0
        System.out.println();

        System.out.println(solution(new int[]{2, 2, 2, 2, 2})); //2
        System.out.println(solution(new int[]{2, 1, 0})); // 1
        System.out.println(solution(new int[]{0, 1, 1})); //#11 1
        System.out.println(solution(new int[]{4, 1})); //#11 1
    }
}
