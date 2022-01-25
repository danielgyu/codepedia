package com.mayfly.interview.strings;

import java.util.HashMap;

public class NonRepeatingCharacter {

    public static void run() {
        String str1 = "abcdcaf";
        System.out.println(" nonRepeatingCharacter() = " + nonRepeatingCharacter(str1));

        String str2 = "aa";
        System.out.println(" nonRepeatingCharacter() = " + nonRepeatingCharacter(str2));
    }

    public static int nonRepeatingCharacter(String string) {
        HashMap<String, Integer> map = new HashMap<>();

        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            String cur = Character.toString(charArray[i]);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            String cur = Character.toString(charArray[i]);
            if (map.get(cur) == 1) {
                return i;
            }
        }

        return -1;
    }
}
