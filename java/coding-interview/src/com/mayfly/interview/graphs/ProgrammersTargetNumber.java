package com.mayfly.interview.graphs;

import java.util.HashMap;
import java.util.Map;

public class ProgrammersTargetNumber {
    static int[] numbers;
    static int target;

    static class Pair {
        int idx;
        int sum;

        public Pair(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }

    public static int solution(int[] numArray, int targetNum) {
        numbers = numArray;
        target = targetNum;
        Map<Pair, Integer> map = new HashMap<>();
        return dfs(map, numbers.length - 1, 0);
    }

    public static int dfs(Map<Pair,Integer> map, int idx, int sum) {
        // valid base case
        Pair cur = new Pair(idx, sum);
        if (map.containsKey(cur)) {
            System.out.println("hit");
            return map.get(cur);
        }
        if (idx < 0 && sum == target) {
            return 1;
        }
        // invalid base case
        if (idx < 0) {
            return 0;
        }

        // decisions
        int positivePath = dfs(map, idx - 1, sum + numbers[idx]);
        int negativePath = dfs(map, idx - 1, sum + -numbers[idx]);
        map.put(new Pair(idx, sum), positivePath + negativePath);

        return positivePath + negativePath;
    }

    public static void run() {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 2));
    }
}
