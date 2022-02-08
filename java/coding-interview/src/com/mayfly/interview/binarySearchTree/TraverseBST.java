package com.mayfly.interview.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraverseBST {

    public static void run() {
        BST head = new BST(10);
        BST node1 = new BST(5);
        BST node2 = new BST(15);
        head.left = node1;
        head.right = node2;
        BST node6 = new BST(22);
        node2.right = node6;
        BST node3 = new BST(2);
        BST node4 = new BST(5);
        node1.left = node3;
        node1.right = node4;
        BST node5 = new BST(1);
        node3.left = node5;

        System.out.println("preOrderTraverse(head, new ArrayList<>()) = " + preOrderTraverse(head, new ArrayList<>()));
        System.out.println("postOrderTraverse(head, new LinkedList<>()) = " + postOrderTraverse(head, new ArrayList<>()));
        System.out.println("inOrderTraverse(head, new ArrayList<>()) = " + inOrderTraverse(head, new ArrayList<>()));
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);

        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            postOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            postOrderTraverse(tree.right, array);
        }

        array.add(tree.value);
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
