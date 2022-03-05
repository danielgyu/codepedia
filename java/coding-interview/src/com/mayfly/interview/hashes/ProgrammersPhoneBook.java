package com.mayfly.interview.hashes;

import java.util.Arrays;
import java.util.HashSet;

public class ProgrammersPhoneBook {

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        System.out.println("phoneBook = " + Arrays.toString(phoneBook));
        HashSet<String> set = new HashSet<>();

        for (int i=0; i < phoneBook.length-1; i++) {
            int j = i+1;
            while (j < phoneBook.length) {
                if (phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                } else if (overOrder(phoneBook[i], phoneBook[j])) {
                    break;
                }
                j++;
            }
        }

        return true;
    }

    public static boolean overOrder(String left, String right) {
        int i = 0;
        while (left.charAt(i) == right.charAt(i)) {
            i++;
        }
        return left.charAt(i) < right.charAt(i);
    }

    public static void run() {
        //System.out.println(solution(new String[]{"12", "123", "567", "88"}));
        //System.out.println(solution(new String[]{"12", "567", "88"}));
        System.out.println(solution(new String[]{"1234", "1235", "1239", "12345"}));
    }
}
