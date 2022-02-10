package com.mayfly.interview.binarySearchTree;

import java.util.ArrayList;

public class FindKthLargest {

    public static void run() {
        BST node1 = new BST(15);
        BST node2 = new BST(5);
        node1.left = node2;
        BST node3 = new BST(2);
        node2.left = node3;
        BST node4 = new BST(1);
        node3.left = node4;
        BST node5 = new BST(3);
        node3.right = node5;
        BST node6 = new BST(20);
        node1.right = node6;
        BST node7 = new BST(17);
        node6.left = node7;
        BST node8 = new BST(22);
        node6.right = node8;

        System.out.println(findKthLargest(node1, 3));
    }

    public static int findKthLargest(BST tree, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        sortBST(tree, array);
        return array.get(k-1);
    }

    public static ArrayList<Integer> sortBST(BST bst, ArrayList<Integer> array) {
        if (bst.right != null) {
            sortBST(bst.right, array);
        }
        array.add(bst.value);
        if (bst.left != null) {
            sortBST(bst.left, array);
        }

        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
