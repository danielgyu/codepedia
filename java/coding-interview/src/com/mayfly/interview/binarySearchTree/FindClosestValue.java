package com.mayfly.interview.binarySearchTree;

import java.net.HttpRetryException;
import java.util.ArrayList;

public class FindClosestValue {
    public void run() {
        BST tree = buildTree();
        int target = 10;
        findClosestValueV1(tree, target);
        findClosestValueV2(tree, target);
    }

    // optimal - doesn't visit all noes, stops when doesn't meet criteria
    public int findClosestValueV2(BST tree, int target) {
        return findClosestinBST(tree, target, tree.value);
    }

    public int findClosestinBST(BST node, int target, int closest) {
        int givenDiff = Math.abs(target - closest);
        int currentDiff = Math.abs(target - node.value);
        if (currentDiff < givenDiff) {
            closest = node.value;
        }

        if (target < node.value && node.left != null) {
            return findClosestinBST(node.left, target, closest);
        } else if (target > node.value && node.right != null) {
            return findClosestinBST(node.left, target, closest);
        } else {
            return closest;
        }
    }


    // less efficient way of doing - visits all nodes in the tree
    public int findClosestValueV1(BST tree, int target) {
        ArrayList<Integer> values = new ArrayList<>();

        values = insertAllValues(tree, values);

        int overallClosest = Integer.MAX_VALUE;
        int result = 0;
        for (int value : values) {
            int currentDiff = Math.abs(target - value);
            if (currentDiff < overallClosest) {
                overallClosest = currentDiff;
                result = value;
            }
        }

        return result;
    }

    public ArrayList<Integer> insertAllValues(BST head, ArrayList<Integer> values) {
        BST node = head;
        if (node != null) {
            values.add(node.value);
        }

        if (node.left != null) {
            values = insertAllValues(node.left, values);
        }

        if (node.right != null) {
            values = insertAllValues(node.right, values);
        }

        return values;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST buildTree() {
        return new BST(1);
    }
}
