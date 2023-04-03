package com.mayfly.interview.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Distancing {
    /* https://school.programmers.co.kr/learn/courses/30/lessons/81302?language=java */

    // dx와 dy의 1, -1순서는 중요하지 않다
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean bfs(String[] room, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            // (less than) 4 for 4 directions
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int distance = Math.abs(x-nx) + Math.abs(y-ny);

                if (nx < 0 || nx >= room.length || ny < 0 || ny >= room.length) continue;
                if (visited[nx][ny] || distance > 2) continue;

                visited[nx][ny] = true;
                char c = room[nx].charAt(ny);
                if (c == 'X') continue;
                else if (c == 'P') return false;
                else  q.offer(new Node(nx, ny));
            }
        }
        return true;
    }

    public int isDistanced(String[] room) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length(); j++) {
                if (room[i].charAt(j) != 'P') continue;
                if (!bfs(room, i, j)) return 0;
            }
        }
        return 1;
    }

    public int[] solution(String[][] places) {
        // P -> person, O -> table, X -> partition
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            result[i] = isDistanced(places[i]);
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        return result;
    }

    public void run() {
        String[][] places = {
            {
                "POOOP",
                "OXXOX",
                "OPXPX",
                "OOXOX",
                "POXXP",
            },
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };
        solution(places);
    }
}
