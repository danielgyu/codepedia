package com.mayfly.interview.graphs.leetcode;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] req : prerequisites) {
            if (!map.containsKey(req[1])) {
                map.put(req[1], new ArrayList<>());
            }
            map.get(req[1]).add(req[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];

        System.out.println("map = " + map);
        for (int i = 0; i < numCourses; i++) {
            if (!isCycle(map, i, visited, checked)) return false;
        }

        return true;
    }

    public static boolean isCycle(Map<Integer, List<Integer>> map, int i, boolean[] visited, boolean[] checked) {
        if (visited[i]) return false;
        if (checked[i] || !map.containsKey(i)) return true;

        visited[i] = true;
        checked[i] = true;
        for (int adj : map.get(i)) {
            if (!isCycle(map, adj, visited, checked)) return false;
        }

        visited[i] = false;
        return true;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] seen = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!search(i, graph, visited, seen)) return false;
        }

        return true;
    }

    public static boolean search(int cur, List<Integer>[] graph, boolean[] visited, boolean[] seen) {
        if (visited[cur]) return false;
        if (seen[cur]) return true;

        seen[cur] = true;
        visited[cur] = true;
        for (int adj : graph[cur]) {
            if (!search(adj, graph, visited, seen)) {
                return false;
            }
        }
        visited[cur] = false;
        return true;
    }

    public static boolean solution2(int numCourses, int[][] prerequisites) {
        int[][] outMatrix = new int[numCourses][numCourses];
        int[] inCount = new int[numCourses];

        for (int[] req : prerequisites) {
            int vertex = req[0];
            int dependsOn = req[1];

            if (outMatrix[dependsOn][vertex] == 0) {
                inCount[vertex]++;
            }
            outMatrix[dependsOn][vertex] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < inCount.length; i++) {
            if (inCount[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;

            for (int i = 0; i < numCourses; i++) {
                if (outMatrix[cur][i] != 0) {
                    if (--inCount[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static boolean solution(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(matrix[pre][ready] == 0) {
                degree[ready]++;
            }
            matrix[pre][ready] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        printValues(matrix, degree, queue);

        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[cur][i] != 0) {
                    if (--degree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void printValues(int[][] matrix, int[] degree, Queue<Integer> queue) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(i + " = " + Arrays.toString(matrix[i]));
        }
        System.out.println("degree = " + Arrays.toString(degree));
        System.out.println("queue = " + queue);
    }

    public static void run() {
        /*
        System.out.println(solution(2, new int[][]{
                {1, 0}
        })); // true

        System.out.println(solution(2, new int[][]{
                {1, 0}, {0, 1}
        })); // false

        System.out.println(solution(5, new int[][]{
                {1, 4}, {2, 4}, {3, 1}, {3, 2}
        })); //true

        System.out.println(solution(8, new int[][]{
                {1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}
        })); // true

        System.out.println(solution(7, new int[][]{
                {1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}
        }));
        System.out.println();

        System.out.println(solution(4, new int[][]{
                {1, 0}, {2, 1}, {0, 2}, {1, 3}
        }));

        System.out.println(solution2(4, new int[][]{
                {1, 0}, {2, 1}, {0, 2}, {1, 3}
        }));

        System.out.println(canFinish(7, new int[][]{
                {1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}
        }));
         */

        System.out.println(canFinish2(7, new int[][]{
                {1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}
        }));
    }
}
