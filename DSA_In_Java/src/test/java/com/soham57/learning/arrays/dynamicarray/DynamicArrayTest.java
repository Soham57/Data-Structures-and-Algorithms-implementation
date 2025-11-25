package com.soham57.learning.arrays.dynamicarray;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    private DynamicArray dynamicArr;

    @BeforeEach
    void setUp() {
        dynamicArr = new DynamicArray();
    }

    @Test
    void testArrayGetCorrectDefaultCapacity() {
        assertNotNull(dynamicArr);
        assertEquals(2, dynamicArr.getCapacity());
        assertEquals(0, dynamicArr.getLength());
    }

    @Test
    void testPushBackIncreasesSizeAndAddsElementReturnsNewLength() {
        dynamicArr.pushBack(2);
        assertEquals(2, dynamicArr.pushBack(3));
        assertEquals("[2, 3]", dynamicArr.toString());
    }

    @Test
    void testPushResizesArrayWhenFilledBeyondCapacity() {
        int capacity = dynamicArr.getCapacity();

        for (int value = 0; value <= capacity; value++) {
            dynamicArr.pushBack(value);
        }

        assertEquals(capacity * 2, dynamicArr.getCapacity());
        assertEquals(capacity + 1, dynamicArr.getLength());
        assertEquals("[0, 1, 2]", dynamicArr.toString());
    }

    @Test
    void testPopBackDecreasesSizeAndReturnsCorrectValue() {
        dynamicArr.pushBack(10);
        dynamicArr.pushBack(20);

        assertEquals(20, dynamicArr.popBack());
        assertEquals(1, dynamicArr.getLength());
        assertEquals(10, dynamicArr.get(0));
    }

    @Test
    void testPopBackThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, dynamicArr::popBack);
    }

    @Test
    void testGetReturnsCorrectValue() {
        dynamicArr.pushBack(5);
        dynamicArr.pushBack(15);

        assertEquals(5, dynamicArr.get(0));
        assertEquals(15, dynamicArr.get(1));
    }

    @Test
    void testGetThrowsExceptionForInvalidIndex() {
        dynamicArr.pushBack(1);

        assertThrows(IllegalArgumentException.class, () -> dynamicArr.get(1));
        assertThrows(IllegalArgumentException.class, () -> dynamicArr.get(-1));
    }

    @Test
    void testInsertAtMiddleShiftsElementsCorrectly() {
        dynamicArr.pushBack(1);
        dynamicArr.pushBack(3);

        assertEquals(3, dynamicArr.insertAt(1, 2));

        assertEquals(3, dynamicArr.getLength());
        assertEquals("[1, 2, 3]", dynamicArr.toString());
    }

    @Test
    void testRemoveAtMiddleShiftsElementsCorrectly() {
        dynamicArr.pushBack(10);
        dynamicArr.pushBack(20);
        dynamicArr.pushBack(30);

        assertEquals(20, dynamicArr.removeAt(1));

        assertEquals(2, dynamicArr.getLength());
        assertEquals("[10, 30]", dynamicArr.toString());
    }

    @Test
    void testRemoveAtLastElement() {
        dynamicArr.pushBack(10);
        dynamicArr.pushBack(20);

        assertEquals(20, dynamicArr.removeAt(1));
        assertEquals(1, dynamicArr.getLength());
        assertEquals("[10]", dynamicArr.toString());
    }

    @Test
    void testRemoveAtThrowsExceptionForInvalidIndex() {
        dynamicArr.pushBack(1);

        assertThrows(IllegalArgumentException.class, () -> dynamicArr.removeAt(1));
        assertThrows(IllegalArgumentException.class, () -> dynamicArr.removeAt(-1));
    }
}