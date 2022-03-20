package com.mayfly.interview.searching;

import java.util.HashSet;
import java.util.Set;

public class ProgrammersPrimeNumber {

    static Set<Integer> set = new HashSet<>();

    public static void permute(String str, String numbers) {
        System.out.println("str = " + str);
        System.out.println("numbers = " + numbers);
        if (!str.equals("")) {
            set.add(Integer.valueOf(str));
        }

        for (int i = 0; i < numbers.length(); i++) {
            System.out.println("i = " + i);
            System.out.println();
            permute(
                    str + numbers.charAt(i),
                    numbers.substring(0, i) + numbers.substring(i + 1)
            );
        }
        System.out.println("end");
    }

    public static int solution(String numbers) {
        permute("", numbers);

        int answer = 0;
        for (Integer val : set) {
            if (isPrime(val)) answer += 1;
        }

        return answer;
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num ==1) return false;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        System.out.println("prime= " + num);

        return true;
    }

    public static void run() {
        //System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
