package com.mayfly.interview.strings;

public class RunLengthEncoding {

    public static void run() {
        String string = "AAAAAAAAAAAABBCCCDDDE";
        System.out.println("runLengthEncoding = " + runLengthEncoding(string));
        String string2 = "aA";
        System.out.println("runLengthEncoding = " + runLengthEncoding(string2));
        String string3 = "122333";
        System.out.println("runLengthEncoding = " + runLengthEncoding(string3));
        String string4 = "  ";
        System.out.println("runLengthEncoding = " + runLengthEncoding(string4));
        String string5 = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println("runLengthEncoding = " + runLengthEncoding(string5));
    }

    public static String runLengthEncoding(String string) {
        String result = "";
        char previous = string.charAt(0);
        int repetition = 1;

        for (int i = 1; i < string.length(); i++) {
            char current = string.charAt(i);

            if (current == previous && repetition < 9) {
                repetition += 1;
            } else {
                result += encode(previous, repetition);
                previous = current;
                repetition = 1;
            }
        }

        result += encode(previous, repetition);
        return result;
    }

    public static String encode(char previous, int repetition) {
        return Integer.toString(repetition) + Character.toString(previous);
    }
}
