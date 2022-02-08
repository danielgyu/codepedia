package com.mayfly.interview.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

    public static void run() {
        BST head = new BST(10);
        BST node1 = new BST(7);
        BST node2 = new BST(12);
        head.left = node1;
        head.right = node2;
        BST node3 = new BST(4);
        BST node4 = new BST(11);
        node1.left = node3;
        node1.right = node4;
        BST node5 = new BST(11);
        BST node6 = new BST(16);
        node2.left = node5;
        node2.right = node6;
        validateBST(head);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void validateBST(BST head) {
        System.out.println(validate(head, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(breadthFirstSearch(head));
    }

    public static boolean breadthFirstSearch(BST node) {
        Queue<BST> queue = new LinkedList<>();
        queue.add(node);
        return search(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean search(Queue<BST> queue, int minValue, int maxValue) {
        return true;
    }

    public static boolean validate(BST node, int minValue, int maxValue) {
        if (node.value < minValue || node.value >= maxValue) { return false; }

        if (node.left != null && !validate(node.left, minValue, node.value)) { return false; }

        if (node.right != null && !validate(node.right, node.value, maxValue)) { return false; }

        return true;
    }
}
