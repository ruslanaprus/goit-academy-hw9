package org.example;

import org.example.customclass.User;
import org.example.mycollections.MyArrayList;
import org.example.mycollections.MyLinkedList;
import org.example.mycollections.MyQueue;
import org.example.mycollections.MyStack;

public class Main {

    public static void main(String[] args) {

        MyStack<String> collection = new MyStack<>();
        System.out.println("collection.isEmpty() = " + collection.isEmpty());

        for (int i = 0; collection.size() <= 20; i++) {
            collection.push("meow" + i);
        }

//        User bob = new User(1, "bob");
//        User alice = new User(2, "alice");
//        User eve = new User(3, "eve");
//        User charlie = new User(4, "charlie");
//
//        MyStack<User> collection = new MyStack<>();
//        collection.push(bob);
//        collection.push(alice);
//        collection.push(eve);
//        collection.push(charlie);

        System.out.println("collection = " + collection);
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
//        System.out.println("collection.get(3) = " + collection.get(3));
        System.out.println("collection.size() = " + collection.size());
        collection.remove(0);
        System.out.println("collection after removal = " + collection);
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection pop item = " + collection.pop());
        System.out.println("collection after pop = " + collection);
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