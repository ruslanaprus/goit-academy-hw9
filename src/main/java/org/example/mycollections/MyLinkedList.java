package org.example.mycollections;

public class MyLinkedList<T> {
    /*
        add(Object value) adds an element to the end
        remove(int index) removes the element with the specified index
        clear() clears the collection
        size() returns the size of the collection
        get(int index) returns the element at index
        isEmpty() check if collection is empty
     */

    private Node head;
    private Node tail;
    private int size;

    public void add(T value) {
        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node current = node(index);
        return current.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node nodeToRemove = node(index);
        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            tail = nodeToRemove.prev;
        }

        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
    }

    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        Node current = head;
        while (current != null) {
            string.append(current.value);
            current = current.next;
            if (current != null) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

    private Node node(int index) {
        Node current;
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private class Node {
        T value;
        Node next;
        Node prev;

        Node(T value) {
            this.value = value;
        }
    }

}