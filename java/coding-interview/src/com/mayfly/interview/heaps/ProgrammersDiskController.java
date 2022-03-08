package com.mayfly.interview.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProgrammersDiskController {
    /*
     * https://maetdori.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-JAVA0w
     */

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) return a1[1] - a2[1];
                return a1[0] - a2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((l, r) -> l[1] - r[1]);

        int end = jobs[0][0];
        int sum = 0;
        int idx = 1;
        pq.offer(jobs[0]);

        while (!pq.isEmpty()) {
            // enqueue job
            int[] cur = pq.poll();
            end += cur[1];
            sum += end - cur[0];

            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }

            if (idx < jobs.length && pq.isEmpty()) {
                end = jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
        }

        int res = sum / jobs.length;
        System.out.println("res = " + res);
        return res;
    }

    public static void run() {
        solution(new int[][]{
                {1, 9},
                {0, 3},
                {2, 6}
        });
    }
}
