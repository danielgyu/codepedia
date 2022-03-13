package com.mayfly.interview.strings;

import java.util.ArrayList;

public class ValidIPAddresses {
    static int start;
    static int end;
    static boolean VALID = true;
    static boolean INVALID = false;

    public static ArrayList<String> solution(String string) {

        ArrayList<String> res = new ArrayList<>();
        start = 0;
        end = string.length();

        for (int i = 1; i < 4; i++) {
            if (i + 3 > end || checkValidity(string.substring(start, i)) == INVALID) break;

            for (int j = i + 1; j < j + 3; j++) {
                if (j + 2 > end || checkValidity(string.substring(i, j)) == INVALID) break;

                for (int k = j + 1; k < end; k++) {
                    if (k + 1 > end || checkValidity(string.substring(j, k)) == INVALID) break;
                    if (checkValidity(string.substring(k, end)) == VALID) res.add(joinString(string, i, j, k));
                }
            }
        }

        return res;
    }

    public static String joinString(String string, int i, int j, int k) {
        String joined = new String(
                string.substring(start, i) + "." +
                        string.substring(i, j) + "." +
                        string.substring(j, k) + "." +
                        string.substring(k, end)
        );
        return joined;
    }

    public static boolean checkValidity(String subString) {
        Integer parsed = Integer.parseInt(subString);
        if ((subString.length() > 1 && subString.startsWith("0")) || parsed.compareTo(255) == 1) {
            return INVALID;
        }
        return VALID;
    }

    public static void run() {
        // System.out.println(solution(new String("1921680")));
        // System.out.println(solution(new String("3700100")));
        System.out.println(solution(new String("100100")));
    }
}
