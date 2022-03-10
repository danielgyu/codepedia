package com.mayfly.interview.strings;

public class LongestPalindromeSubstring {
    public static String solution(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            longest = checkEven(str, i, longest);
            longest = checkOdd(str, i, longest);
        }
        return longest;
    }

    public static String checkEven(String str, int idx, String longest) {
        String palindrome = Character.toString(str.charAt(idx));
        return expand(str, idx - 1, idx + 1, palindrome, longest);
    }

    public static String checkOdd(String str, int idx, String longest) {
        if (idx > 0 && str.charAt(idx) == str.charAt(idx-1)) {
            String palindrome = Character.toString(str.charAt(idx)) + Character.toString(str.charAt(idx-1));
            return expand(str, idx - 2, idx + 1, palindrome, longest);
        }
        return longest;
    }

    public static String expand(String str, int left, int right, String palindrome, String longest) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            palindrome = str.charAt(left) + palindrome + str.charAt(right);
            left--;
            right++;
        }

        return palindrome.length() > longest.length() ? palindrome : longest;
    }

    public static void run() {
        System.out.println(solution("abaxyzzyxf"));
        System.out.println(solution("abcdcba"));
        System.out.println(solution("a"));
    }
}
