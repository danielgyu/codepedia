package com.mayfly.interview.binaryTree;

public class BinaryTreeDiameter {

    public static int binaryTreeDiameter(BST tree) {
        return getTreeInfo(tree).diameter;
    }

    public static TreeInfo getTreeInfo(BST tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameter = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        int curDiameter = Math.max(longestPathThroughRoot, maxDiameter);
        int curHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(curDiameter, curHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
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
}
