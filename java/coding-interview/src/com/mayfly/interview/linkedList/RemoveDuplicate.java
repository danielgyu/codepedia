package com.mayfly.interview.linkedList;

public class RemoveDuplicate {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        while (linkedList != null) {
            LinkedList next = linkedList.next;

            while (next != null && linkedList.value == next.value) {
                next = next.next;
            }

            linkedList.next = next;
            linkedList = linkedList.next;
        }

        return null;
    }
}
