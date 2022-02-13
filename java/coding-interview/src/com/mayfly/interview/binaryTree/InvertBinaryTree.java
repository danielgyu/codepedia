package com.mayfly.interview.binaryTree;

import com.mayfly.interview.binarySearchTree.ReconstructBST;

public class InvertBinaryTree {
    
    public static void invertBinaryTree(BST tree) {
        if (tree != null) {
            BST temp;
            temp = tree.left;
            tree.left= tree.right;
            tree.right = temp;

            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

    }
    
    public static void run() {
        BST node1 = new BST(1);
        BST node2 = new BST(2);
        BST node3 = new BST(3);
        node1.left = node2;
        node1.right = node3;
        BST node4 = new BST(4);
        BST node5 = new BST(5);
        node2.left = node4;
        node2.right = node5;
        BST node6 = new BST(6);
        BST node7 = new BST(7);
        node3.left = node6;
        node3.right = node7;
        BST node8 = new BST(8);
        BST node9 = new BST(9);
        node4.left = node8;
        node4.right = node9;

        invertBinaryTree(node1);
        System.out.println("node1.right.right.left.value = " + node1.right.right.left.value);

        BST a1 = new BST(1);
        BST a2 = new BST(2);
        a1.left = a2;
        invertBinaryTree(a1);
        System.out.println("a1.left = " + a1.left);
        System.out.println("a1.right.value = " + a1.right.value);
    }
}