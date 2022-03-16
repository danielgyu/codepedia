package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ProgrammersWordChangeLvl3 {
    static String targetWord;
    static int answer = 0;

    public static class Node {
        String word;
        List<String> words;
        int level;

        public Node(String word, List<String> words, int level) {
            this.word = word;
            this.words = words;
            this.level = level;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        targetWord = target;

        Stack<Node> stack = new Stack<>();
        Node root = new Node(begin, new ArrayList<>(Arrays.asList(words)), 0);

        stack.add(root);
        while (!stack.empty()) {
            Node popped = stack.pop();
            dfs(popped, stack);
        }
        return answer;
    }

    public static void dfs(Node node, Stack<Node> stack) {
        if (node.word.equals(targetWord)) {
            if (answer != 0) {
                answer = Math.min(answer, node.level);
            } else {
                answer = node.level;
            }
            return;
        };

        for (String word : node.words) {
            if (getAlphabetDifference(node.word, word) == 1) {
                List<String> list = new ArrayList<>(node.words);
                list.remove(word);
                stack.add(new Node(word, list, node.level + 1));
            }
        }
    }

    public static int getAlphabetDifference(String base, String word) {
        int diff = 0;
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) != word.charAt(i)) diff+=1;
        }
        return diff;
    }

    public static void run() {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        //System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
