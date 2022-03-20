package com.mayfly.interview.graphs;

import java.util.*;

public class ProgrammersFarthestNode {
    // static MaxDepth maxDepth;
    // static HashMap<Integer, Integer> memo = new HashMap<>();
    static List<List<Integer>> connections = new ArrayList<>();
    static boolean[] visited;

    public static int solution2BFS(int n, int[][] edges) {
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            connections.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }

        return bfs();
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int count = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                for (Integer adjacent : connections.get(current)) {
                    if (!visited[adjacent]) {
                        temp.add(adjacent);
                        visited[adjacent] = true;
                    }
                }
            }
            if (temp.isEmpty()) break;
            queue.addAll(temp);
            count = temp.size();
        }

        return count;
    }

    /*
    public static class MaxDepth{
        int depth;
        int count;

        public MaxDepth(int depth, int count) {
            this.depth  = depth;
            this.count = count;
        }
    }

    public static int solution1(int n, int[][] edges) {
        // initialize map
        Map<Integer, List<Integer>> vertices = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            vertices.put(i, new ArrayList<>());
        }

        // organize vertices and edges
        for (int[] edge : edges) {
            List<Integer> l1 = vertices.get(edge[0]);
            l1.add(edge[1]);
            List<Integer> l2 = vertices.get(edge[1]);
            l2.add(edge[0]);
        }
        System.out.println("vertices = " + vertices);

        // go over and count the depths
        maxDepth = new MaxDepth(0, 1);

        for (int i = 2; i <= n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            dfs(vertices, i, visited, 1);
        }

        System.out.println("memo = " + memo);
        return maxDepth.count;
    }

    public static boolean dfs(Map<Integer, List<Integer>> map, int edge, Set<Integer> visited, int depth) {
        if (memo.containsKey(edge)) {
            determineMaxDepth(depth);
            return true;
        }

        if (map.get(edge).contains(1)) {
            determineMaxDepth(depth);
            memo.put(edge, depth);
            return true;
        }
        if (map.get(edge).size() == 0) return false;

        for (Integer e : map.get(edge)) {
            if (visited.contains(e)) continue;

            visited.add(e);
            if (dfs(map, e, visited, depth+1)) break;
            visited.remove(e);
        }

        return false;
    }

    public static void determineMaxDepth(int depth) {
        if (depth < maxDepth.depth) return;
        else if (depth == maxDepth.depth) maxDepth.count++;
        else maxDepth = new MaxDepth(depth , 1);

    }
     */

    public static void run() {
        System.out.println(solution2BFS(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        }));
    }
}
