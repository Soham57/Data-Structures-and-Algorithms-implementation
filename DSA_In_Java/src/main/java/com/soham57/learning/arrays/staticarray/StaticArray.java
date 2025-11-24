package com.soham57.learning.arrays.staticarray;

import java.util.NoSuchElementException;

public class StaticArray {
    private final int [] data;
    private final int capacity;
    private int size;

    public StaticArray(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity is invalid. Must be positive.");
        }
        this.capacity = capacity;
        this.size = 0;
        data = new int[capacity];
    }

    public void push(int num){
        if (size == capacity) {
            throw new IllegalStateException("Array is full. Cannot push.");
        }
        data[size] = num;
        size++;
    }

    public int pop(){
        if(size == 0){
            throw new NoSuchElementException("Cannot pop from an empty array");
        }
        int poppedValue = data[--size];
        data[size] = 0;
        return poppedValue;
    }

    public void insertAt(int index, int value){
        if (size == capacity) {
            throw new IllegalStateException("Array is full. Cannot insert.");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for insertion (0 to " + size + ")");
        }

        for(int rightIdx = size; rightIdx > index; rightIdx--){
            data[rightIdx] = data[rightIdx - 1];
        }

        data[index] = value;
        size++;
    }

    public int removeAt(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds (0 to " + (size - 1) + ")");
        }

        int removedValue = data[index];

        for(int idx = index; idx < size - 1; idx++){
            data[idx] = data[idx + 1];
        }

        data[size - 1] = 0;
        size--;
        return removedValue;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int idx = 0; idx < size; idx++) {
            sb.append(data[idx]);
            if (idx < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}