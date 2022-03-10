package com.mayfly.interview.greedy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int solution(int[] queries) {
        Arrays.sort(queries);
        int[] waitingArray = new int[queries.length];

        int waitingTime = 0;
        for (int i = 1; i < queries.length; i++) {
            waitingTime += queries[i-1];
            waitingArray[i] = waitingTime;
        }

        int answer = 0;
        for (int i = 0; i < waitingArray.length; i++) {
            answer += waitingArray[i];
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public static void run() {
        solution(new int[]{3, 2, 1, 2, 6});
    }
}
