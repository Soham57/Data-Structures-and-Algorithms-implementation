package com.soham57.learning.linkedlists.doublylinkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @BeforeEach
    public void setup() {
        list = new DoublyLinkedList();
    }

    @Test
    void linkedListShouldBeEmptyInitially() {
        assertEquals("", list.toString());
    }

    @Test
    void shouldInsertFrontIntoEmptyList() {
        list.insertFront(10);

        assertEquals("10", list.toString());

        list.insertEnd(20);
        assertEquals("10<=>20", list.toString(), "Tail update failed after insertFront on empty list.");
    }

    @Test
    void shouldInsertFrontIntoNonEmptyList() {
        list.insertFront(20);
        list.insertFront(10);

        assertEquals("10<=>20", list.toString());

        list.insertEnd(30);
        assertEquals("10<=>20<=>30", list.toString());
    }

    @Test
    void shouldInsertEndIntoEmptyList() {
        list.insertEnd(100);
        assertEquals("100", list.toString());

        list.insertEnd(200);
        assertEquals("100<=>200", list.toString());
    }

    @Test
    void shouldInsertEndIntoNonEmptyList() {
        list.insertFront(1);
        list.insertFront(2);

        list.insertEnd(3);

        assertEquals("2<=>1<=>3", list.toString());

        list.insertEnd(4);
        assertEquals("2<=>1<=>3<=>4", list.toString());
    }

    @Test
    void shouldNotRemoveFrontFromEmptyList() {
        list.removeFront();
        assertEquals("", list.toString());
    }

    @Test
    void shouldRemoveFrontLeavingListEmpty() {
        list.insertFront(50);
        list.removeFront();

        assertEquals("", list.toString());

        list.insertEnd(100);
        assertEquals("100", list.toString(), "Tail was not reset to head after removing the last element.");
    }

    @Test
    void shouldRemoveFrontFromMultipleElements() {
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);

        list.removeFront();
        assertEquals("20<=>30", list.toString());

        list.removeFront();
        assertEquals("30", list.toString());

        list.removeFront();
        assertEquals("", list.toString());
    }

    @Test
    void shouldNotRemoveEndFromEmptyList() {
        list.removeEnd();
        assertEquals("", list.toString());
    }

    @Test
    void shouldRemoveEndLeavingListEmpty() {
        list.insertFront(100);
        list.removeEnd();

        assertEquals("", list.toString());

        list.insertEnd(200);
        assertEquals("200", list.toString(), "Tail was not reset to head after removing the single element via removeEnd.");
    }

    @Test
    void shouldRemoveEndFromMultipleElements() {
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);

        list.removeEnd();
        assertEquals("10<=>20", list.toString());

        list.removeEnd();
        assertEquals("10", list.toString());
    }

    @Test
    void shouldHandleMixedInsertionsAndRemovals() {
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertFront(0);

        list.removeEnd();
        assertEquals("0<=>1", list.toString());

        list.removeFront();
        assertEquals("1", list.toString());

        list.insertEnd(3);
        assertEquals("1<=>3", list.toString());

        list.removeEnd();
        list.removeFront();

        assertEquals("", list.toString());
    }
}