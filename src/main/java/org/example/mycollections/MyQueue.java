package org.example.mycollections;

import java.util.StringJoiner;

public class MyQueue<T> {
    /*
        add(Object value) adds an element to the end
        clear() clears the collection
        size() returns the size of the collection
        peek() returns the first element from the queue
        poll() returns the first element from the queue and removes it from the collection
        isEmpty() check if collection is empty
     */

    private static final int SIZE = 30;
    private T[] data;
    private int tail;
    private int head;
    private int count;

    public MyQueue() {
        data = (T[]) new Object[SIZE];
        head = 0;
        tail = -1;
        count = 0;
    }

    public void add(T x) {
        if (count == SIZE) {
            throw new IllegalStateException("Queue is full");
        }
        tail = (tail + 1) % SIZE;
        data[tail] = x;
        count++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = data[head];
        data[head] = null;
        head = (head + 1) % SIZE;
        count--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[head];
    }

    public void clear() {
        data = (T[]) new Object[SIZE];
        head = 0;
        tail = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = head; i <= tail; i++) {
            result.add(String.valueOf(data[i]));
        }
        return result.toString();
    }
}