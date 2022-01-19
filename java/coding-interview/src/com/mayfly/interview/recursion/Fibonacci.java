package com.mayfly.interview.recursion;

import java.util.HashMap;

public class Fibonacci {
    public static int getNthFib(int n) {
        return getFib(n, new HashMap());
    }

    public static int getFibWithoutMemo(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return getFibWithoutMemo(n - 1) + getFibWithoutMemo(n - 2);
    }

    public static int getFib(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        memo.put(n, getFib(n - 1, memo) + getFib(n - 2, memo));
        return memo.get(n);
    }
}
