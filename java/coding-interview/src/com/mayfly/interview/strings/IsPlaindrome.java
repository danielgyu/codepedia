package com.mayfly.interview.strings;

public class IsPlaindrome {

    public static void run() {
        System.out.println(isPlaindrome("abcdcba"));
        System.out.println(isPlaindrome("bfeb"));
    }

    public static boolean isPlaindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
