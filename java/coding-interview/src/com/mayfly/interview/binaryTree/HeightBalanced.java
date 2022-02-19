package com.mayfly.interview.binaryTree;

public class HeightBalanced {
    public static boolean heightBalanced(BST bst) {
        int res = getDifference(bst);
        System.out.println("res = " + res);
        return res > 0;
    }

    public static int getDifference(BST bst) {
        if (bst.left == null && bst.right == null) {
            System.out.println();
            return 1;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (bst.left != null) {
            leftHeight = getDifference(bst.left);
        }
        if (bst.right != null) {
            rightHeight = getDifference(bst.right);
        }

        int diff = Math.abs(leftHeight - rightHeight);
        System.out.println("bst.value = " + bst.value);
        System.out.println("leftHeight = " + leftHeight);
        System.out.println("rightHeight = " + rightHeight);
        System.out.println();

        return diff > 1 ? Integer.MIN_VALUE : Math.max(leftHeight, rightHeight) + 1;
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
        node3.right = node6;
        BST node7 = new BST(7);
        BST node8 = new BST(8);
        node5.left = node7;
        node5.right = node8;

        // not balanced
        BST node10 = new BST(10);
        node8.right = node10;
        BST node11 = new BST(11);
        node10.right = node11;
        System.out.println("heightBalanced(node1) = " + heightBalanced(node1));
    }
}
