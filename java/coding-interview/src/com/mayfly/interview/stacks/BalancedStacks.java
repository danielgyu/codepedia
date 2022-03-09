package com.mayfly.interview.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedStacks {
    public static boolean solution(String str) {
        String openings = "([{";
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character cur = str.charAt(i);
            if (map.containsKey(cur)) {
                if (stack.size() == 0 || stack.pop() != map.get(cur)) return false;
            } else if (openings.contains(cur.toString())){
                stack.push(cur);
            }
        }

        return stack.size() == 0;
    }

    public static void run() {
        boolean res1 = solution("([])(){}(())()()");
        System.out.println("res1 = " + res1);
    }
}
