package com.soham57.learning.linkedlists.singlylinkedlist;

public class SinglyLinkedList {

    private final ListNode head;
    private ListNode tail;

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
    }

    private ListNode findPredecessor(int index) {
        ListNode node = head;
        int idx = 0;

        while (node.next != null && idx < index) {
            node = node.next;
            idx++;
        }
        return node;
    }

    public void insertAtEnd(int value) {
        tail.next = new ListNode(value);
        tail = tail.next;
    }

    public void insertAt(int index, int value) {
        if (index < 0) return;

        ListNode node = findPredecessor(index);

        ListNode newNode = new ListNode(value);
        newNode.next = node.next;
        node.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void removeAt(int index) {
        if (index < 0) return;

        ListNode node = findPredecessor(index);

        ListNode nextNode = node.next;
        if (nextNode == null) {
            return;
        }

        node.next = nextNode.next;

        if (node.next == null) {
            tail = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder linkedListStr = new StringBuilder();
        ListNode node = head.next;

        while (node != null) {
            linkedListStr.append(node.value).append(node.next != null ? "->" : "");
            node = node.next;
        }

        return linkedListStr.toString();
    }
}