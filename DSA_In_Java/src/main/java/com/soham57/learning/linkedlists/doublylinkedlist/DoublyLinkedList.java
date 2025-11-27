package com.soham57.learning.linkedlists.doublylinkedlist;

public class DoublyLinkedList {
    DoublyListNode head;
    DoublyListNode tail;

    private static class DoublyListNode {
        int value;
        DoublyListNode next;
        DoublyListNode prev;

        public DoublyListNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        this.head = new DoublyListNode(-1);
        this.tail = this.head;
    }

    public void insertFront(int value) {
        DoublyListNode newNode = new DoublyListNode(value);
        DoublyListNode nextNode = head.next;
        head.next = newNode;

        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        } else {
            tail = newNode;
        }

        return;
    }

    public void insertEnd(int value) {
        DoublyListNode newNode = new DoublyListNode(value);

        if (!isEmpty()) {
            newNode.prev = tail;
        }
        tail.next = newNode;
        tail = tail.next;

        return;
    }

    public void removeFront() {
        if (isEmpty()) {
            return;
        }

        DoublyListNode firstNode = head.next;
        DoublyListNode nextNode = firstNode.next;
        head.next = nextNode;

        if (nextNode == null) {
            tail = head;
        }

        return;
    }

    public void removeEnd() {
        if (isEmpty()) {
            return;
        }

        DoublyListNode lastNode = tail;
        tail = lastNode.prev == null ? head : lastNode.prev;
        tail.next = null;

        return;
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    public Integer getFirstValue(){
        if(isEmpty()){
            return null;
        }
        return head.next.value;
    }

    public Integer getLastValue(){
        if(isEmpty()){
           return null;
        }
        return tail.value;
    }

    @Override

    public String toString() {
        DoublyListNode currNode = head.next;
        StringBuilder listInStr = new StringBuilder();

        while (currNode != null) {
            listInStr.append(currNode.value).append(currNode.next != null ? "<=>" : "");
            currNode = currNode.next;
        }

        return listInStr.toString();
    }
}
