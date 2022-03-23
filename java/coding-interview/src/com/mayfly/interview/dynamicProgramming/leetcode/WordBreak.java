package com.mayfly.interview.dynamicProgramming.leetcode;

import java.util.*;

public class WordBreak {

    public static boolean solution(String s, List<String> wordDict) {
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return bfsOptimized(s, wordDict);
        //return bfs(s, wordDict, 0);
        //return dfs(s, wordDict);
    }

    public static boolean bfsOptimized(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int i = cur + 1; i <= s.length(); i++) {
                if (visited.contains(i)) continue;
                if (wordDict.contains(s.substring(cur, i))) {
                    if (i == s.length()) return true;
                    visited.add(i);
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public static boolean dfs(String s, List<String> wordDict) {
        Stack<String> stack = new Stack<>();
        stack.add(s);

        while (!stack.isEmpty()) {
            String cur = stack.pop();

            for (String word : wordDict) {
                if (cur.equals(word)) return true;

                String leftover = cur;
                if (cur.startsWith(word)) {
                    stack.add(leftover.substring(word.length()));
                    while (leftover.startsWith(word)) {
                        leftover = leftover.substring(word.length());
                    }
                    stack.add(leftover);
                }
                /*
                else if (cur.startsWith(word)) {
                    String leftover = cur.substring(word.length());
                    stack.add(leftover);
                }
                 */
            }
        }

        return false;
    }

    public static boolean bfs(String s, List<String> wordDict, int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);

        Set<Integer> visited = new HashSet<>();
        visited.add(idx);

        while (!queue.isEmpty()) {
            Integer curIdx = queue.poll();
            if (visited.contains(curIdx)) continue;

            int before = queue.size();

            for (String word : wordDict) {
                Integer sumIdx = curIdx + word.length();

                if (sumIdx <= s.length() && s.substring(curIdx, sumIdx).equals(word)) {
                    if (sumIdx == s.length()) return true;
                    queue.add(sumIdx);
                }
            }
            if (queue.size() == before) {
                System.out.println("adding to visited=" + curIdx);
                visited.add(curIdx);
            }
        }

        return false;
    }

    public static void run() {
        System.out.println(solution("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")))); // true
        System.out.println(solution("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat")))); // false
        System.out.println(solution("ccbb", new ArrayList<>(Arrays.asList("bc", "cb")))); // false
        System.out.println(solution("catskicatcats", new ArrayList<>(Arrays.asList("cats", "cat", "dog", "ski")))); // true
        System.out.println(solution("a", new ArrayList<>(Arrays.asList("b")))); // false
    }
}
