package com.mayfly.interview.heaps;

import java.util.PriorityQueue;

public class ProgrammersSpicy {

    public static int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for (int index : scoville) {
            pqueue.add(index);
        }

        int count = 0;
        while (pqueue.size() > 1) {
            if (pqueue.peek() >= k) {
                return count;
            }
            Integer first = pqueue.poll();
            Integer second = pqueue.poll();
            pqueue.add(first + (second * 2));
            count++;
        }

        return pqueue.peek() >= k ? count : -1;
    }

    public static void run() {
        int res1 = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("res1 = " + res1);
        int res2 = solution(new int[]{1, 1}, 3);
        System.out.println("res2 = " + res2);
    }
}
