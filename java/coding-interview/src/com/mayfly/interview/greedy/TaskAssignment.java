package com.mayfly.interview.greedy;

import java.util.*;

public class TaskAssignment {
    public static Map<Integer, Integer> getHashMap() {
        Map<Integer, Integer> map = new HashMap<>();
        // TODO
        return map;
    }

    public static ArrayList<ArrayList<Integer>> solution(int k, ArrayList<Integer> tasks) {
        Collections.sort(tasks);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = tasks.size()-1;

        while (left < right) {
            ans.add(new ArrayList<>(Arrays.asList(left++, right--)));
        }
        return ans;
    }

    public static void run() {
        System.out.println(solution(3, new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4))));
    }
}
