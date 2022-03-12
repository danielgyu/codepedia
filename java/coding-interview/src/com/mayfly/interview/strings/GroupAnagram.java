package com.mayfly.interview.strings;

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> solution(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String sorted = sort(word);
            if (map.containsKey(sorted)) {
                List<String> list = map.get(sorted);
                list.add(word);
            } else {
                map.put(sorted, new ArrayList<>(Arrays.asList(word)));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static String sort(String word) {
        char[] temp = word.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static void run() {
        System.out.println(solution(new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"))));
    }
}
