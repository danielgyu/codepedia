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
        //return bfs(s, wordDict);
        return dfs(s, wordDict);
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

    public static boolean bfs(String s, List<String> wordDict) {
        System.out.println("wordDict = " + wordDict);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            for (String word : wordDict) {
                if (cur.equals(word)) return true;
                else if (cur.startsWith(word)) {
                    String leftover = cur.substring(word.length());
                    queue.add(leftover);
                }
            }
        }

        return false;
    }

    public static void run() {
        //System.out.println(solution("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")))); // true
        //System.out.println(solution("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat")))); // false
        //System.out.println(solution("ccbb", new ArrayList<>(Arrays.asList("bc", "cb")))); // false
        System.out.println(solution("catskicatcats", new ArrayList<>(Arrays.asList("cats", "cat", "dog", "ski")))); // true
    }
}
