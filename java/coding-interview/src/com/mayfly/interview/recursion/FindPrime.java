package com.mayfly.interview.recursion;

import java.util.HashSet;

public class FindPrime {
    /*
     * https://school.programmers.co.kr/learn/courses/30/lessons/42839
     */
    private int answer = 0;
    private HashSet<Integer> visited = new HashSet();

    public void isPrime(String stringNumber) {
        if (stringNumber.startsWith("0") || stringNumber.equals("")) {
            return;
        }

        Integer number = Integer.parseInt(stringNumber);
        if (number <= 1 || visited.contains(number)) return;

        for (int i = 2; i *i <= number; i++) {
            if (number % i == 0) return;
        }
        visited.add(number);
        this.answer++;
    }

    public void recurse(String numbers, String current) {
        isPrime(current);

        if (numbers.length() == 0) return;

        // 123이라는 숫자가 있다고 했을 때,
        // (123, "") (23, 1), (3, 12), ("", 123), (2, 13), ("", 132) 이런식으로 숫자를 분해한다
        // 왼쪽 오른쪽이 numbers, current이고,
        // 현재 스택 프레임에 저장된 numbers, current 기준으로 for문을 돈다**
        for (int i = 0; i < numbers.length(); i++) {
            String sub = numbers.substring(0, i) + numbers.substring(i+1);
            recurse(sub, current + numbers.charAt(i));
        }
    }

    public int solution(String numbers) {
        /*
         * numbers의 각 digit을 조합
         * 매 조합마다 prime인지 아닌지 확인
         */
        recurse(numbers, "");
        System.out.println("answer = " + answer);
        return this.answer;
    }

    public void run() {
        //solution("17");
        solution("011");
    }
}
