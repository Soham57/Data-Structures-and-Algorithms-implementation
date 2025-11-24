package com.soham57.learning.arrays.staticarray;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

class StaticArrayTest {

    private StaticArray array;

    // Use @BeforeEach to set up a fresh array before every test method
    @BeforeEach
    void setUp() {
        array = new StaticArray(5);
    }

    // --- Constructor Tests ---

    @Test
    void testConstructorWithValidCapacity() {
        StaticArray validArray = new StaticArray(10);
        assertNotNull(validArray);
        assertEquals("[]", validArray.toString());
    }

    @Test
    void testConstructorWithInvalidCapacity() {
        // Assert that the expected exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            new StaticArray(0);
        }, "Should throw IllegalArgumentException for capacity <= 0");
    }

    // --- push() Tests ---

    @Test
    void testPushIncreasesSizeAndAddsElement() {
        array.push(10);
        assertEquals("[10]", array.toString(), "Array content should be [10]");
        array.push(20);
        assertEquals("[10, 20]", array.toString(), "Array content should be [10, 20]");
    }

    @Test
    void testPushThrowsExceptionWhenFull() {
        // Fill the array (capacity 5)
        for (int i = 1; i <= 5; i++) {
            array.push(i);
        }
        assertEquals("[1, 2, 3, 4, 5]", array.toString(), "Array should be full");

        // Try to push one more element
        assertThrows(IllegalStateException.class, () -> {
            array.push(6);
        }, "Should throw IllegalStateException when pushing to a full array");
    }

    // --- pop() Tests ---

    @Test
    void testPopRemovesLastElementAndReturnsValue() {
        array.push(10);
        array.push(20);
        array.push(30);

        // Pop 30
        int poppedValue = array.pop();
        assertEquals(30, poppedValue, "Pop should return the last element (30)");
        assertEquals("[10, 20]", array.toString(), "Array should now be [10, 20]");

        // Pop 20
        assertEquals(20, array.pop(), "Pop should return 20");
    }

    @Test
    void testPopThrowsExceptionWhenEmpty() {
        assertEquals("[]", array.toString(), "Array should be initially empty");

        assertThrows(NoSuchElementException.class, () -> {
            array.pop();
        }, "Should throw NoSuchElementException when popping from an empty array");
    }

    // --- insertAt() Tests ---

    @Test
    void testInsertAtMiddle() {
        array.push(10);
        array.push(30); // [10, 30]
        array.insertAt(1, 20); // Insert 20 at index 1

        assertEquals("[10, 20, 30]", array.toString(), "Insert at index 1 failed");
    }

    @Test
    void testInsertAtStart() {
        array.push(10);
        array.insertAt(0, 5); // Insert 5 at index 0

        assertEquals("[5, 10]", array.toString(), "Insert at index 0 failed");
    }

    @Test
    void testInsertAtEnd() {
        array.push(10); // [10]
        array.insertAt(1, 20); // Insert 20 at index 1 (the current size)

        assertEquals("[10, 20]", array.toString(), "Insert at current size (end) failed");
    }

    @Test
    void testInsertAtThrowsExceptionWhenFull() {
        // Fill the array (capacity 5)
        for (int i = 1; i <= 5; i++) {
            array.push(i);
        }

        assertThrows(IllegalStateException.class, () -> {
            array.insertAt(2, 99);
        }, "Should throw IllegalStateException when inserting into a full array");
    }

    @Test
    void testInsertAtThrowsIndexOutOfBounds() {
        // Array is empty, size is 0
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertAt(1, 10); // index > size (0)
        }, "Should throw for index > size");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertAt(-1, 10); // index < 0
        }, "Should throw for index < 0");
    }

    // --- removeAt() Tests ---

    @Test
    void testRemoveAtMiddle() {
        array.push(10);
        array.push(20);
        array.push(30); // [10, 20, 30]

        int removedValue = array.removeAt(1); // Remove 20

        assertEquals(20, removedValue, "removeAt should return the correct value (20)");
        assertEquals("[10, 30]", array.toString(), "Array should shift elements: [10, 30]");
    }

    @Test
    void testRemoveAtEnd() {
        array.push(10);
        array.push(20);
        array.push(30); // [10, 20, 30]

        int removedValue = array.removeAt(2); // Remove 30

        assertEquals(30, removedValue, "removeAt should return the correct value (30)");
        assertEquals("[10, 20]", array.toString(), "Array after removing at size-1: [10, 20]");
    }

    @Test
    void testRemoveAtStart() {
        array.push(10);
        array.push(20); // [10, 20]

        int removedValue = array.removeAt(0); // Remove 10

        assertEquals(10, removedValue, "removeAt should return the correct value (10)");
        assertEquals("[20]", array.toString(), "Array after removing at index 0: [20]");
    }

    @Test
    void testRemoveAtThrowsIndexOutOfBounds() {
        array.push(10); // size is 1

        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.removeAt(1); // index == size (1)
        }, "Should throw for index >= size");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.removeAt(-1); // index < 0
        }, "Should throw for index < 0");

        // Test remove from empty array
        StaticArray emptyArray = new StaticArray(5);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            emptyArray.removeAt(0); // index 0 on an empty array
        }, "Should throw for index >= size (0) on empty array");
    }

    // --- toString() Tests ---

    @Test
    void testToStringEmpty() {
        assertEquals("[]", array.toString(), "toString should return '[]' for an empty array");
    }

    @Test
    void testToStringOneElement() {
        array.push(42);
        assertEquals("[42]", array.toString(), "toString should return '[42]' for one element");
    }

    @Test
    void testToStringMultipleElements() {
        array.push(1);
        array.push(2);
        array.push(3);
        assertEquals("[1, 2, 3]", array.toString(), "toString should return comma-separated values");
    }
}