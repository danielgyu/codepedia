package com.mayfly.interview.programmers.levelthree;

import java.util.Arrays;

public class Immigration {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 1;
        long max = (long)times[times.length-1] * n;
        long mid;
        long sum;
        long answer = max;

        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;

            for (int time: times) {
                sum += mid / time;
            }

            if (sum >= n) {
                if (mid < answer) {
                    answer = mid;
                }
                max = mid -1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }

    public static void run() {
        //System.out.println(solution(6, new int[]{7, 10}));
        //System.out.println(solution(1, new int[]{8, 90, 78}));
        //System.out.println(solution(2, new int[]{8, 90, 78}));
        System.out.println(solution(3, new int[]{2, 3}));
    }
}
