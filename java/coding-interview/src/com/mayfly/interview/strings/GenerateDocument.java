package com.mayfly.interview.strings;

import java.util.HashMap;

public class GenerateDocument {

    public static void run() {
        String sentence = "abc def $a";
        System.out.println(generateDocument(sentence, "abc"));
        System.out.println(generateDocument("abacabc", "aabbccc"));
    }

    public static boolean generateDocument(String characters, String document) {
        HashMap<String, Integer> counter = new HashMap<>();

        populateCounter(counter, characters);
        return checkOccurrence(counter, document);
    }

    public static void populateCounter(HashMap<String, Integer> counter, String characters) {
        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            String str = Character.toString(ch);

            if (counter.containsKey(str)) {
                counter.put(str, counter.get(str) + 1);
            } else {
                counter.put(str, 1);
            }
        }

    }

    public static boolean checkOccurrence(HashMap<String, Integer> counter, String document) {
        for (int i = 0; i < document.length(); i++) {
            char ch = document.charAt(i);
            String str = Character.toString(ch);

            if (counter.containsKey(str) && counter.get(str) > 0) {
                counter.put(str, counter.get(str) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
