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
        data = new Node[INITIAL_CAPACITY];
        threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
        size = 0;
    }

    public void put(K key, V value) {
        if (size >= threshold) {
            resize();
        }

        int hash = Objects.hashCode(key);
        int index = hash & (data.length - 1); // will always produce a valid index within the array bounds

        for (Node<K, V> entry = data[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        Node<K, V> newNode = new Node<>(key, value, data[index]);
        data[index] = newNode;
        size++;
    }

    public V get(K key) {
        int hash = Objects.hashCode(key);
        int index = hash & (data.length - 1);

        for (Node<K, V> entry = data[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = Objects.hashCode(key);
        int index = hash & (data.length - 1);
        Node<K, V> prev = null;

        for (Node<K, V> entry = data[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && Objects.equals(entry.key, key)) {
                if (prev == null) {
                    data[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
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

    private void resize() {
        Node<K, V>[] oldData = data;
        int newCapacity = data.length * 2;
        data = new Node[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);
        size = 0;

        for (Node<K, V> node : oldData) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            hash = Objects.hashCode(key);
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}