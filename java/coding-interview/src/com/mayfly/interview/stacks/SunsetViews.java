package com.mayfly.interview.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SunsetViews {

    public static List<Integer> solution(int[] buildings, String direction) {
        List<Integer> res = new ArrayList<>();

        if (direction == "EAST") {
            int tallest = buildings[buildings.length-1];
            res.add(buildings.length-1);

            for (int i = buildings.length-2; i >= 0; i--) {
                tallest = determineTaller(i, buildings[i], tallest, res);
            }
        } else {
            int tallest = buildings[0];
            res.add(0);

            for (int i = 1; i < buildings.length; i++) {
                tallest = determineTaller(i, buildings[i], tallest, res);
            }
        }

        return direction == "EAST" ? reverse(res) : res;
    }

    public static List<Integer> reverse(List<Integer> res) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = res.size()-1; i >= 0; i--) {
            reversed.add(res.get(i));
        }
        return reversed;
    }

    public static int determineTaller(int i, int current, int tallest, List<Integer> res) {
        if (current > tallest) {
            res.add(i);
            return current;
        }
        return tallest;
    }

    public static void run() {
        System.out.println(solution(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
        System.out.println(solution(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
        System.out.println(solution(new int[]{2, 4}, "WEST"));
    }
}
