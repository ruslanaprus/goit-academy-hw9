package org.example;

import org.example.customclass.User;
import org.example.mycollections.MyArrayList;
import org.example.mycollections.MyLinkedList;
import org.example.mycollections.MyQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        MyQueue<String> collection = new MyQueue<>();
//        System.out.println("collection.isEmpty() = " + collection.isEmpty());
//
//        for (int i = 0; collection.size() <= 29; i++) {
//            collection.add("meow" + i);
//        }

        User bob = new User(1, "bob");
        User alice = new User(2, "alice");
        User eve = new User(3, "eve");
        User charlie = new User(4, "charlie");

        MyQueue<User> collection = new MyQueue<>();
        collection.add(bob);
        collection.add(alice);
        collection.add(eve);
        collection.add(charlie);

        System.out.println("collection = " + collection);
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
//        System.out.println("collection.get(3) = " + collection.get(3));
        System.out.println("collection.size() = " + collection.size());
        collection.poll();
        System.out.println("collection after removal = " + collection);
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.peek() = " + collection.peek());
        System.out.println("collection after peek() = " + collection);
        System.out.println("collection.size() = " + collection.size());
        collection.clear();
        System.out.println("collection after clear = " + collection);
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.isEmpty() = " + collection.isEmpty());

    }

}