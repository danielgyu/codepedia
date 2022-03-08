package com.mayfly.interview.stacks;

import java.util.List;
import java.util.Stack;

public class MinMaxStack {

    public static class Node {
        Integer value;
        Integer min;
        Integer max;

        public Node(Integer value, Integer min, Integer max) {
            this.value = value;
            this.min = min;
            this.max = max;
        }
    }

    public static class MyMinMaxStack {
        Stack<Node> stack = new Stack<>();

        public int peek() {
            return stack.peek().value;
        };

        public int pop() {
            return stack.pop().value;
        };

        public void push(Integer number) {
            if (stack.size() == 0) {
                stack.push(new Node(number, number, number));
            } else if (number < this.getMin()) {
                stack.push(new Node(number, number, this.getMax()));
            } else if (number > this.getMax()) {
                stack.push(new Node(number, this.getMin(), number));
            } else {
                stack.push(new Node(number, this.getMin(), this.getMax()));
            }
        };

        public int getMin() {
            return stack.peek().min;
        };

        public int getMax() {
            return stack.peek().max;
        };
    }

    public static void run() {
        MyMinMaxStack stack = new MyMinMaxStack();
        stack.push(100);
        stack.push(70);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.getMin() = " + stack.getMin());
        System.out.println("stack.getMax() = " + stack.getMax());

        Integer popped = stack.pop();
        System.out.println("popped = " + popped);
        System.out.println("stack.getMin() = " + stack.getMin());
        System.out.println("stack.getMax() = " + stack.getMax());
    }
}
