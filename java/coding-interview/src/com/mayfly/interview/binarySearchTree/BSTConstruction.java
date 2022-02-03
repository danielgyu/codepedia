package com.mayfly.interview.binarySearchTree;

public class BSTConstruction {

    public static void run() {
        BST head = new BST(10);
        head.insert(8);
        head.insert(12);
        head.insert(11);
        head.insert(13);
        head.insert(14);
        System.out.println("head.right.right.value = " + head.right.right.value);
        System.out.println();

        System.out.println("head.contains(9) = " + head.contains(9));
        System.out.println("head.contains(9) = " + head.contains(13));
        System.out.println();

        System.out.println("head.right.right = " + head.right.right.value);
        head.remove(13);
        System.out.println("head.right.right = " + head.right.right.value);
        System.out.println();

        head.remove(14);
        System.out.println("head.right.right = " + head.right.right);
        System.out.println();


        System.out.println("head.right.left = " + head.right.left.value);
        head.remove(10);
        System.out.println("head.value = " + head.value);
        System.out.println("head.right.left = " + head.right.left);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST node = this;
            BST previous = this;
            while (node != null) {
                previous = node;
                if (value < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (value < previous.value) {
                previous.left = new BST(value);
            } else {
                previous.right = new BST(value);
            }

            return this;
        }

        public boolean contains(int value) {
            BST node = this;
            while (node != null) {
                if (node.value == value) {
                    return true;
                } else if (value < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return false;
        }

        public BST remove(int value) {
            BST previous = this;
            BST node = this;
            while (node != null) {
                if (node.value == value) {
                    break;
                } else if (value < node.value) {
                    previous = node;
                    node = node.left;
                } else {
                    previous = node;
                    node = node.right;
                }
            }

            if (node != null) {
                if (node.left == null && node.right == null) {
                    // no child
                    if (value < previous.value) {
                        previous.left = null;
                    } else {
                        previous.right = null;
                    }

                } else if (node.left == null || node.right == null){
                    // one child
                    if (node.left == null && value < previous.value) {
                        previous.left = node.right;
                    } else if (node.left == null && value > previous.value) {
                        previous.right = node.right;
                    } else if (node.right == null && value < previous.value) {
                        previous.left = node.left;
                    } else {
                        previous.right = node.left;
                    }

                } else {
                    BST min = node.right;
                    while (min.left != null) {
                        previous = min;
                        min = min.left;
                    }
                    node.value = min.value;
                    previous.left = null;
                }
            }

            return this;
        }
    }
}
