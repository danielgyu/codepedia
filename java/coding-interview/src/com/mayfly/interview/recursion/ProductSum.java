package com.mayfly.interview.recursion;

import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static void run() {
        /*
         * [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
         * 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)
         * 7 + 12 + 3 - 10 = 12
         * 5 + 2 + 12 + 3 - 10 = 12
         */
        List<Object> array = Arrays.asList(
                5,
                2,
                Arrays.asList(7, -1),
                3,
                Arrays.asList(6, Arrays.asList(-13, 8), 4)
        );

        System.out.println("array = " + array);
        System.out.println("productSum = " + productSum(array));
    }

    public static int productSum(List<Object> array) {
        int totalSum = 0;
        int depth = 1;
        for (Object o : array) {
            totalSum += getSum(o, depth);
        }

        return totalSum;
    }

    public static int getSum(Object object, int depth) {
        if (object instanceof Integer) {
            return (int) object;
        }

        int sum = 0;
        depth += 1;
        for (Object o : (List) object) {
            sum += getSum(o, depth);
        }

        return sum * depth;
    }
}
