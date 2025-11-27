package com.soham57.learning.queue;

import com.soham57.learning.linkedlists.doublylinkedlist.DoublyLinkedList;

public class Queue {
    private final DoublyLinkedList queue;

    public Queue(){
        queue = new DoublyLinkedList();
    }

    public void enqueue(int value){
        queue.insertEnd(value);
    }

    public Integer dequeue(){
        Integer removedValue = queue.getFirstValue();

        if(!queue.isEmpty()){
            queue.removeFront();
        }

        return removedValue;
    }

    public Integer peek(){
        return queue.getFirstValue();
    }
}
