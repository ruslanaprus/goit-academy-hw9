package org.example.mycollections;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyStack<T> {
    /*
        push(Object item) adds an element onto the top of this stack
        remove(int index) removes the element at index
        clear() clears the collection
        size() returns the size of the collection
        peek() returns the element at the top of the stack
        pop() returns the element at the top of the stack and removes it from the collection
        isEmpty() check if collection is empty
     */

    private static final int INITIAL_CAPACITY = 10;
    private T[] data;
    private int size;

    public MyStack() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T item) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size] = item;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = data[size - 1];
        data[size - 1] = null;
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2); // Halve the array size when it's one quarter full
        }
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
        resize(INITIAL_CAPACITY);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(data[i]));
        }
        return result.toString();
    }

}