package com.mayfly.interview.binarySearchTree;

public class BSTConstruction {

    public static void run() {
        BST head = new BST(4);
        head.insert(3);
        head.insert(2);
        head.insert(1);
        head.remove(2);
        System.out.println("head.value = " + head.value);
        System.out.println("head.left.value = " + head.left.value);
        System.out.println("head.left.left.value = " + head.left.left.value);
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
                    if (node.left == null) {
                        if (node == this) {
                            node.value = node.right.value;
                            node.right = node.right.right;
                        } else if (value < previous.value) {
                            previous.left = node.right;
                        } else {
                            previous.right = node.right;
                        }
                     } else {
                        if (node == this) {
                            node.value = node.left.value;
                            node.left = node.left.left;
                        } else if (value < previous.value) {
                            previous.left = node.left;
                        } else {
                            previous.right = node.left;
                        }
                    }

                } else {
                    BST min = node.right;
                    if (min.left != null) {
                        while (min.left != null) {
                            previous = min;
                            min = min.left;
                        }
                        node.value = min.value;
                        previous.left = null;
                    } else {
                        node.value = min.value;
                        node.right = null;
                    }
                }
            }

            return this;
        }
    }
}
