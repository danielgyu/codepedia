package com.mayfly.interview.graphs;

import java.util.Arrays;

public class CycleInGraph {

    public static boolean solution(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        for (int[] vertex : edges) {
            for (int out : vertex) {
                if (dfs(edges, visited, out)) return true;
            }
        }

        return false;
    }

    public static boolean dfs(int[][] edges, boolean[] visited, int out) {
        if (visited[out]) return true;
        if (edges[out].length == 0) return false;

        visited[out] = true;
        for (int o : edges[out]) {
            if (dfs(edges, visited, o)) return true;
        }

        visited[out] = false;
        return false;
    }

    public static void run() {
        System.out.println(solution(new int[][]{
                {1, 4},
                {2, 3},
                {},
                {},
                {}
        }));

        System.out.println(solution(new int[][]{
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        }));
    }
}
