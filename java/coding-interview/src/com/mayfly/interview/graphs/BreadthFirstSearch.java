package com.mayfly.interview.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);

                for (Node child : node.children) {
                    queue.add(child);
                }
            }

            System.out.println("array = " + array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void run() {
        Node head = new Node("A");
        head.addChild("B");
        head.addChild("C");
        head.addChild("D");

        head.breadthFirstSearch(new ArrayList<String>());
    }
}
