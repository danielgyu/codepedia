package com.mayfly.interview.binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructBST {

    public static void run() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
        BST head = reconstructBST(array);
        System.out.println("head.left.right.value.value = " + head.left.right.value);
        System.out.println("head.right.right.left.value = " + head.right.right.left.value);
    }

    public static BST reconstructBST(ArrayList<Integer> array) {
        BST head = null;
        for (int i = 0; i < array.size(); i++) {
            if (head == null) {
                head = new BST(array.get(i));
            } else {
                head.insert(array.get(i));
            }
        }
        return head;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public void insert(int num) {
            if (num < this.value && this.left != null) {
                this.left.insert(num);
            } else if (num < this.value && this.left == null) {
                this.left = new BST(num);
            } else if (num >= this.value && this.right != null) {
                this.right.insert(num);
            } else if (num >= this.value && this.right == null) {
                this.right = new BST(num);
            }
        }
    }
}
