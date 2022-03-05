package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getPermutations(0, array, res);
        System.out.println("res = " + res);
        return res;
    }

    public static void getPermutations(int index, List<Integer> array, List<List<Integer>> res) {
        if (index == array.size() - 1) {
            System.out.println("array = " + array);
            res.add(new ArrayList<>(array));
        } else {
            for (int j = index; j < array.size(); j++) {
                System.out.println("i, j: " + index + "  " + j);
                swap(array, index, j);
                getPermutations(index + 1, array, res);
                swap(array, index, j);
                System.out.println("next loop, i, j: " + index + "  " + j);
            }
        }
    }

    public static void swap(List<Integer> array, int i, int j) {
        //System.out.println("i, j: " + i + "  " + j);
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static void run() {
        getPermutations(new ArrayList<>(Arrays.asList(1, 2, 3)));
        //getPermutations(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
    }
}
