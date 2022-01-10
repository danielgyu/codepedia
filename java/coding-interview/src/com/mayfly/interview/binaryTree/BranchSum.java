package com.mayfly.interview.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public void run() {}

    public List<Integer> branchSum(BinaryTree root) {
        ArrayList<Integer> result = new ArrayList<>();

        int initialSum = 0;
        return findAllSum(root, initialSum, result);

        /* Version 2 */
        // findAllSumV2(root, initialSum, result);
        // return result;
    }

    public static void findAllSumV2(BinaryTree node, int sum, ArrayList<Integer> result) {
        if (node == null) return;

        sum += node.value;
        if (node.left == null & node.right == null) {
            result.add(sum);
            return;
        }

        findAllSumV2(node.left, sum, result);
        findAllSumV2(node.right, sum, result);
    }

    public static ArrayList<Integer> findAllSum(BinaryTree node, int sum, ArrayList<Integer> result) {
        sum += node.value;

        if (node.left != null) {
            result = findAllSum(node.left, sum, result);
        }

        if (node.right != null) {
            result = findAllSum(node.right, sum, result);
        }

        if (node.right == null && node.left == null) {
            result.add(sum);
            return result;
        }

        return result;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            value = value;
        }
    }

}
