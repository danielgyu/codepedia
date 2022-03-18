package com.mayfly.interview.sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProgrammersBiggestNumber {

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.toString(numbers[i]));
        }

        List<String> res = mergeSort(list);
        return String.join("", res);
    }

    public static List<String> mergeSort(List<String> list) {
        if (list.size() == 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<String> left = mergeSort(list.subList(0, mid));
        List<String> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    public static List<String> merge(List<String> left, List<String> right) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (compare(left.get(i), right.get(j)) >= 0) {
                res.add(left.get(i++));
            } else {
                res.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            res.add(left.get(i++));
        }
        while (j < right.size()) {
            res.add(right.get(j++));
        }

        return res;
    }

    public static int compare(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) > s2.charAt(j)) {
                return 1;
            } else if (s1.charAt(i) < s2.charAt(j)) {
                return -1;
            }
            i++;
            j++;
        }
        if (i < s1.length()) return s1.charAt(i) > s2.charAt(0) ? 1 : -1;
        else return s2.charAt(j) > s1.charAt(0) ? -1 : 1;
    }

    public static String solution2(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println("a+b = " + a+b);
                System.out.println("b+a = " + b+a);
                System.out.println();
                return (b+a).compareTo(a+b);
            }
        });

        if (str[0].equals("0")) return "0";

        String answer = "";
        for (String s : str) answer += s;
        return answer;
    }

    public static void run() {
        /*
        System.out.println(solution(new int[]{0, 0, 0, 0})); // 0
        System.out.println(solution(new int[]{40, 403}));
        System.out.println(solution(new int[]{40, 405}));
        System.out.println(solution(new int[]{40, 404}));
        System.out.println(solution(new int[]{12, 121}));
        System.out.println(solution(new int[]{22, 2, 223}));
         */

        /*
        System.out.println(solution2(new int[]{0, 0, 0, 0})); // 0
        System.out.println(solution2(new int[]{40, 403}));
        System.out.println(solution2(new int[]{40, 405}));
        System.out.println(solution2(new int[]{40, 404}));
        System.out.println(solution2(new int[]{12, 121}));
         */
        System.out.println(solution2(new int[]{22, 2, 223}));
    }
}
