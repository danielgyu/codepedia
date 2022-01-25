package com.mayfly.interview.strings;

public class CaesarCipherEncryptor {
    private static final int lastAlphabet = 122;
    private static final int alphabetLength = 26;

    public static void run() {
        System.out.println("caesarEncryptor = " + caesarEncryptor("abc", 1));
        System.out.println("caesarEncryptor = " + caesarEncryptor("xyz", 1));
    }

    public static String caesarEncryptor(String str, int key) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int newPosition = ((int) ch) + (key % alphabetLength + 1);
            if (newPosition > lastAlphabet) {
                newPosition -= alphabetLength;
            }

            char newChar = (char) newPosition;
            result += newChar;
        }

        return result;
    }
}
