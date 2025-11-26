package com.soham57.learning.linkedlists.singlylinkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    SinglyLinkedList singlyList;

    @BeforeEach
    public void setUp() {
        singlyList = new SinglyLinkedList();
    }

    @Test
    void linkedListShouldBeEmptyInitially() {
        assertEquals("", singlyList.toString());
    }

    @Test
    void shouldBeAbleToAddNewNodes() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);
        singlyList.insertAtEnd(54);

        assertEquals("5->90->586->54", singlyList.toString());
    }

    @Test
    void shouldCorrectlyRemoveElementsAndInsertAfterIt() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);
        singlyList.insertAtEnd(54);
        singlyList.removeAt(2);

        assertEquals("5->90->54", singlyList.toString());

        singlyList.insertAtEnd(67);
        singlyList.insertAtEnd(98);

        assertEquals("5->90->54->67->98", singlyList.toString());
    }

    @Test
    void shouldBeAbleToRemoveOnlyOneElementThenAddMore() {
        singlyList.insertAtEnd(5);

        singlyList.removeAt(0);

        assertEquals("", singlyList.toString());

        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);

        assertEquals("5->90->586", singlyList.toString());
    }

    @Test
    void shouldBeAbleToRemoveValueAtHead() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);
        singlyList.removeAt(0);

        assertEquals("90->586", singlyList.toString());
    }

    @Test
    void shouldBeAbleToRemoveAtEnd() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);
        singlyList.removeAt(2);

        assertEquals("5->90", singlyList.toString());
    }

    @Test
    void passingInvalidIndexShouldNotMutateList() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);
        singlyList.insertAtEnd(586);

        singlyList.removeAt(-1);
        singlyList.removeAt(10);

        assertEquals("5->90->586", singlyList.toString());
    }
    @Test
    void shouldInsertAtBeginningOfEmptyList() {
        singlyList.insertAt(0, 100);
        assertEquals("100", singlyList.toString(),
                "Insert at index 0 on an empty list failed.");
    }

    @Test
    void shouldInsertAtBeginningOfNonEmptyList() {
        singlyList.insertAtEnd(10);
        singlyList.insertAtEnd(20);

        singlyList.insertAt(0, 5);

        assertEquals("5->10->20", singlyList.toString(),
                "Insert at index 0 failed.");
    }

    @Test
    void shouldInsertInTheMiddle() {
        singlyList.insertAtEnd(1);
        singlyList.insertAtEnd(2);
        singlyList.insertAtEnd(4);

        singlyList.insertAt(2, 3);

        assertEquals("1->2->3->4", singlyList.toString(),
                "Insert at a middle index failed.");
    }

    @Test
    void shouldInsertAtTheEnd() {
        singlyList.insertAtEnd(1);
        singlyList.insertAtEnd(2);

        singlyList.insertAt(2, 3);

        assertEquals("1->2->3", singlyList.toString(),
                "Insert at the current end (new tail) failed.");
    }

    @Test
    void shouldCorrectlyUpdateTailWhenInsertingAtEnd() {
        singlyList.insertAtEnd(1);
        singlyList.insertAtEnd(2);

        singlyList.insertAt(2, 3);

        singlyList.insertAtEnd(4);

        assertEquals("1->2->3->4", singlyList.toString(),
                "Tail update was incorrect after insertAt end.");
    }


    @Test
    void passingInvalidIndexShouldNotMutateListInsertAt() {
        singlyList.insertAtEnd(5);
        singlyList.insertAtEnd(90);

        singlyList.insertAt(-1, 999);

        singlyList.insertAt(100, 500);

        assertEquals("5->90->500", singlyList.toString(),
                "List state changed unexpectedly after invalid index operations.");
    }
}