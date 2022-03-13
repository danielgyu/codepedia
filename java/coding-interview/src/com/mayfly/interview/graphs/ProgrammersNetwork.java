package com.mayfly.interview.graphs;

import java.util.*;

public class ProgrammersNetwork {

    public static int solution(int n, int[][] computers) {
        // create dependency map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < computers.length; i++) {
            List<Integer> dependencyList = new ArrayList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] != 0) dependencyList.add(j);
            }
            map.put(i, dependencyList);
        }

        // loop over map k, v to get groups in stack
        Set<Integer> set = new HashSet<>();
        Stack<List<Integer>> stack = new Stack<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) {
                continue;
            }
            set.add(entry.getKey());
            List<Integer> group = new ArrayList<>(Arrays.asList(entry.getKey()));
            topologicalSortUtil(map, set, group, entry.getValue());
            stack.add(group);
        }

        // calculate the length of stack
        return stack.size();
    }

    public static void topologicalSortUtil(
            Map<Integer, List<Integer>> map,
            Set<Integer> set,
            List<Integer> group,
            List<Integer> dependencyList) {
        for (Integer dependency : dependencyList) {
            if (set.contains(dependency)) continue;
            set.add(dependency);
            group.add(dependency);
            topologicalSortUtil(map, set, group, map.get(dependency));
        }
    }

    public static void run() {

        System.out.println(solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        }));
        System.out.println(solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1},
        }));
    }
}
