package com.mayfly.interview.binaryTree;

public class HeightBalanced {
    public static boolean heightBalanced(BST bst) {
        return true;
    }

    public static int X(BST bst) {
        if (bst.left == null && bst.right == null) {
            return 1;
        }

        int left = X(bst.left);
        int right = X(bst.right);
        
        return Math.abs(left - right) > 1 ? TOO_BIG : 1;
    }
}
