package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getPermutations(0, array, res);
        return res;
    }

    public static void getPermutations(int index, List<Integer> array, List<List<Integer>> res) {
        if (index == array.size() - 1) {
            System.out.println("adding index");
            res.add(new ArrayList<>(array));
        } else {
            for (int j = index; j < array.size(); j++) {
                swap(array, index, j);
                getPermutations(index + 1, array, res);
                swap(array, index, j);

                if (index == 0) System.out.println();
            }
        }
    }

    public static void swap(List<Integer> array, int i, int j) {
        System.out.println("i=" + i + "  " + "j=" + j);
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    // From https://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
    public static ArrayList<ArrayList<Integer>> iterativePermutation(List<Integer> array) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        res.add(new ArrayList<>());

        for (int i = 0; i < array.size(); i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, array.get(i));

                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            res = new ArrayList<ArrayList<Integer>>(current);
        }

        return res;
    }

    // From Cracking the Coding Interview
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> res = new ArrayList<String>();

        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutation(rest), last);
        }
        return res;
    }

    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        for (String s : list) {
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }

    public static void run() {
        System.out.println(getPermutations(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(iterativePermutation(new ArrayList<>(Arrays.asList(1, 2, 3))));
        //getPermutations(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
    }
}
