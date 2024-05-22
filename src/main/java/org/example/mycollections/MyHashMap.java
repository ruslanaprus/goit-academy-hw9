package org.example.mycollections;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {
    /*
        put(Object key, Object value) dds a key + value pair
        remove(Object key) removes the key pair
        clear() clears the collection
        size() returns the size of the collection
        get(Object key) returns the value (Object value) by key
     */

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] data;
    private int size;
    private int threshold;

    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this(capacity, LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        if (capacity <= 0 || loadFactor <= 0 || loadFactor >= 1) {
            throw new IllegalArgumentException("Invalid capacity or load factor");
        }
        data = new Node[capacity];
        threshold = (int) (capacity * loadFactor);
        size = 0;
    }

    public void put(K key, V value) {
        if (size >= threshold) {
            resize(data.length * 2);
        }

        int hash = (key == null) ? 0 : key.hashCode();
        int index = hash & (data.length - 1); // will always produce a valid index within the array bounds

        for (Node<K, V> entry = data[index]; entry != null; entry = entry.next) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        data[index] = new Node<>(key, value, data[index]);
        size++;
    }

    public V get(K key) {
        int hash = (key == null) ? 0 : key.hashCode();
        int index = hash & (data.length - 1);

        for (Node<K, V> entry = data[index]; entry != null; entry = entry.next) {
            if (Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = (key == null) ? 0 : key.hashCode();
        int index = hash & (data.length - 1);
        Node<K, V> prev = null;
        Node<K, V> entry = data[index];

        while (entry != null) {
            if (Objects.equals(entry.key, key)) {
                if (prev == null) {
                    data[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                break;
            }
            prev = entry;
            entry = entry.next;
        }

        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < data.length; i++) {
            Node<K, V> current = data[i];
            while (current != null) {
                result.add(current.key + "=" + current.value);
                current = current.next;
            }
        }
        return result.toString();
    }


    private void resize(int newCapacity) {
        Node<K, V>[] oldData = data;
        data = (Node<K, V>[]) new Node[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);

        for (Node<K, V> node : oldData) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = (node.key == null) ? 0 : node.key.hashCode() & (newCapacity - 1);
                node.next = data[index];
                data[index] = node;
                node = next;
            }
        }
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}