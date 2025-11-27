package com.soham57.learning.queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue queue;

    @BeforeEach
    public void setup() {
        queue = new Queue();
    }

    // --- Tests for enqueue() ---

    @Test
    void enqueue_ShouldAddElementToTheQueue() {
        queue.enqueue(10);
        assertEquals(10, queue.peek());

        queue.enqueue(20);
        assertEquals(10, queue.peek());
    }

    // --- Tests for peek() ---

    @Test
    void peek_ShouldReturnNullWhenQueueIsEmpty() {
        assertNull(queue.peek(),
                "Peek should return null on an empty queue.");
    }

    @Test
    void peek_ShouldReturnFirstElementWithoutRemovingIt() {
        queue.enqueue(5);

        assertEquals(5, queue.peek());

        assertEquals(5, queue.peek());
    }

    @Test
    void peek_ShouldReturnCorrectFirstElementWhenMultipleExist() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.peek());
    }

    // --- Tests for dequeue() ---

    @Test
    void dequeue_ShouldReturnNullWhenQueueIsEmpty() {
        assertNull(queue.dequeue(),
                "Dequeue should return null on an empty queue.");
    }

    @Test
    void dequeue_ShouldRemoveAndReturnTheSingleElement() {
        queue.enqueue(99);

        Integer result = queue.dequeue();

        assertEquals(99, result);
        assertNull(queue.peek(), "Queue should be empty after dequeuing the single element.");
    }

    @Test
    void dequeue_ShouldMaintainFIFOOrder() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue(), "First dequeue must return 10 (FIFO).");
        assertEquals(20, queue.peek(), "Peek must now return the next element, 20.");

        assertEquals(20, queue.dequeue(), "Second dequeue must return 20.");
        assertEquals(30, queue.dequeue(), "Third dequeue must return 30.");

        assertNull(queue.peek(), "Queue must be empty after all elements are removed.");
    }

    @Test
    void dequeue_ShouldHandleConsecutiveRemovalsCorrectly() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        assertNull(queue.dequeue());

        queue.enqueue(3);
        assertEquals(3, queue.dequeue());
        assertNull(queue.peek());
    }
}