package com.mayfly.interview.strings;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseWordsInString {

    public static String solution(String string) {
        String result = "";

        Deque<String> token = new LinkedList<>();
        for (int i = string.length()-1; i >= 0; i--) {
            String cur = String.valueOf(string.charAt(i));
            if (cur.equals(" ")) {
                result += tokenToWord(token);
                result += cur;
            } else {
                token.addFirst(cur);
            }
        }
        result += tokenToWord(token);

        return result;
    }

    public static String tokenToWord(Deque<String> token) {
        String word = "";
        while (!token.isEmpty()) {
            word += token.poll();
        }
        return word;
    }

    public static void run() {
        System.out.println(solution("AlgoExpert is the best!"));
        System.out.println(solution("whitespaces    4"));
        System.out.println(solution("abc d "));
    }
}
