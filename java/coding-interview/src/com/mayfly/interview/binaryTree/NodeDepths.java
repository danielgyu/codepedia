package com.mayfly.interview.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NodeDepths {
    public static int nodeDepths(BinaryTree root) {
        List<Integer> depths = new ArrayList<>();
        depthSum(root.left, 0, depths);
        depthSum(root.right, 0, depths);

        return depths.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    public static List<Integer> depthSum(BinaryTree node, int depth, List<Integer> depths) {
        if (node == null) {
            return depths;
        }

        depth += 1;
        depths.add(depth);

        depthSum(node.left, depth, depths);
        depthSum(node.right, depth, depths);

        return depths;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
