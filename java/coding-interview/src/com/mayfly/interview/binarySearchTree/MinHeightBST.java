package com.mayfly.interview.binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void run() {
        List<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
        BST head1 = minHeightBST(array1);

        List<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36));
        BST head2 = minHeightBST(array2);

        List<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1));
        BST head3 = minHeightBST(array3);

        List<Integer> array4 = new ArrayList<Integer>(Arrays.asList(1, 2));
        BST head4 = minHeightBST(array4);

        List<Integer> array5 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36));
        BST head5 = minHeightBSTV2(array5);
        System.out.println("head5.right.right.right.value = " + head5.right.right.right.value);
    }

    public static BST minHeightBSTV2(List<Integer> array) {
        return constructBST(array, null, 0, array.size() - 1);
    }

    public static BST constructBST(List<Integer> array, BST bst, int startIdx, int endIdx) {
        if (endIdx < startIdx) { return null; }
        int mid = (startIdx + endIdx) / 2;
        if (bst == null) {
            bst = new BST(array.get(mid));
        } else {
            bst.insert(array.get(mid));
        }

        constructBST(array, bst, startIdx, mid - 1);
        constructBST(array, bst, mid + 1, endIdx);
        return bst;
    }

    public static BST minHeightBST(List<Integer> array) {
        if (array.size() == 1) {
            return new BST(array.get(0));
        }
        if (array.size() == 2) {
            BST head = new BST(array.get(0));
            head.insert(array.get(1));
            return head;
        }

        return splitIntoHalf(null, array);
    }

    public static BST splitIntoHalf(BST head, List<Integer> array) {
        int mid = getMiddleIndex(array.size());

        if (head == null) {
            head = new BST(array.get(mid));
        } else {
            head.insert(array.get(mid));
        }

        if (array.size() > 1 && mid > 0) {
            splitIntoHalf(head, array.subList(0, mid));
        }
        if (array.size() > 1 && mid < array.size()) {
            splitIntoHalf(head, array.subList(mid + 1, array.size()));
        }

        return head;
    }

    public static int getMiddleIndex(int size) {
        if (size % 2 == 0) {
            return size / 2 - 1;
        } else {
            return size / 2;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
