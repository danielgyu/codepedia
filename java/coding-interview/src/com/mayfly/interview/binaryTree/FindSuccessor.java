package com.mayfly.interview.binaryTree;

import java.util.ArrayList;

public class FindSuccessor {
    /*
     * utilize the characteristic of BST to find its successor
     * in-order-traversal characteristic: left -> self -> right
     *
     * two scenarios:
     * 1) if the target node has a right node
     * - the successor will be the leftmost node of its right node
     *
     * 2) if the target node does not have a right node
     * - the successor can be its parent (if it's the left node of its parent)
     * - or it can be the parent of the parent (if its the right node of its parent)
     */

    public static BST findSuccessor(BST tree, BST node) {
        if (node.right != null) return getLetMostChild(node.right);
        return getRightMostParent(node);
    }

    public static BST getLetMostChild(BST node) {
        BST cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public static BST getRightMostParent(BST node) {
        BST cur = node;
        while (cur.parent != null && cur.parent.right == node) {
            cur = cur.parent;
        }
        return cur.parent;
    }

    public static void run() {
        BST node1 = new BST(1);
        BST node2 = new BST(2);
        BST node3 = new BST(3);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        BST node4 = new BST(4);
        BST node5 = new BST(5);
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        BST node6 = new BST(6);
        node4.left = node6;
        node6.parent = node4;

        BST successor1 = findSuccessor(node1, node5);
        System.out.println("successor1 = " + successor1.value);
    }
}
