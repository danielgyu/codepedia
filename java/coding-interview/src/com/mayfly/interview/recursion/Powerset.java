package com.mayfly.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {
    /*
     * Go over all the inserted elements in the res array
     * and make a combination out of it
     */

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (Integer num : array) {
            List<List<Integer>> subResult = new ArrayList<>();

            for (List<Integer> subset : res) {
                if (!subset.isEmpty()) {
                    List<Integer> copy = new ArrayList<>(subset);
                    copy.addAll(new ArrayList<>(Arrays.asList(num)));
                    subResult.add(copy);
                }
            }

            res.add(new ArrayList<>(Arrays.asList(num)));
            res.addAll(subResult);
        }
        System.out.println("res = " + res);
        return res;
    }
    
    public static void run() {
        powerset(new ArrayList<>(Arrays.asList(1, 2, 3)));
        powerset(new ArrayList<>(Arrays.asList()));
    }
}
