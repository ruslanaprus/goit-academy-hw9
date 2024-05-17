package org.example.mycollections;

import java.util.*;

public class MyArrayList<T> {
    /*
        add(Object value) adds an element to the end
        remove(int index) removes the element with the specified index
        clear() clears the collection
        size() returns the size of the collection
        get(int index) returns the element at index
        isEmpty() check if collection is empty
     */

    public static final int INITIAL_CAPACITY = 10;

    private T[] data;

    private int size;

    public MyArrayList() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newSize = data.length * 2;
            data = Arrays.copyOf(data, newSize);
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
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