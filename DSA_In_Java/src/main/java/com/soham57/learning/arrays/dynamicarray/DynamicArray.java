package com.soham57.learning.arrays.dynamicarray;

public class DynamicArray {
    private int[] data;
    private int length = 0;
    private int capacity = 2;

    public DynamicArray() {
        data = new int[capacity];
    }

    public int pushBack(int value) {
        if (isArrayFilled()) {
            resizeArray();
        }
        data[length] = value;
        length++;

        return length;
    }

    public int popBack() {
        if (length == 0) {
            throw new IllegalStateException("Array has no elements");
        }
        int poppedValue = data[length - 1];
        data[--length] = 0;

        return poppedValue;
    }

    public int insertAt(int index, int value) {
        if (indexOutOfBounds(index)) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        if (isArrayFilled()) {
            resizeArray();
        }

        for (int idx = length; idx >= index; idx--) {
            data[idx] = data[idx - 1];
        }
        data[index] = value;
        length++;

        return length;
    }

    public int removeAt(int index) {
        if (indexOutOfBounds(index)) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        if (length == 0) {
            throw new IllegalStateException("Array has no elements");
        }

        int valueTobeRemoved = data[index];
        if (index == length - 1) {
            return popBack();
        }
        for (int idx = index; idx < length - 1; idx++) {
            data[idx] = data[idx + 1];
        }
        data[--length] = 0;

        return valueTobeRemoved;
    }

    public int get(int index) {
        if (indexOutOfBounds(index)) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        if (length == 0) {
            throw new IllegalStateException("Array has no elements");
        }

        return data[index];
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resizeArray() {
        capacity = length * 2;
        int[] newData = new int[capacity];

        for (int idx = 0; idx < length; idx++) {
            newData[idx] = data[idx];
        }
        data = newData;
    }

    boolean indexOutOfBounds(int index) {
        return index < 0 || index >= length;
    }

    boolean isArrayFilled() {
        return length == capacity;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }
        StringBuilder dataArrInStr = new StringBuilder("[");

        for (int idx = 0; idx < length; idx++) {
            dataArrInStr.append(data[idx]);
            if (idx < length - 1) dataArrInStr.append(", ");
        }
        dataArrInStr.append("]");

        return dataArrInStr.toString();
    }
}
