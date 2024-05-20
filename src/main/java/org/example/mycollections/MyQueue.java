package org.example.mycollections;

import java.util.Arrays;
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

    private static final int INITIAL_CAPACITY = 10;
    private T[] data;
    private int tail;
    private int head;
    private int size;

    public MyQueue() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void add(T item) {
        if (size == data.length) {
            resize();
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
        size++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[head];
    }

    public void clear() {
        Arrays.fill(data, 0, data.length, null);
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(data[(head + i) % data.length]));
        }
        return result.toString();
    }
}