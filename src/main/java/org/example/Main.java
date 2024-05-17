package org.example;

import org.example.customclass.User;
import org.example.mycollections.MyArrayList;
import org.example.mycollections.MyLinkedList;

public class Main {

    public static void main(String[] args) {

//        MyLinkedList<String> collection = new MyLinkedList<>();
//        System.out.println("collection.isEmpty() = " + collection.isEmpty());
//
//        for (int i = 0; collection.size() <= 20; i++) {
//            collection.add("meow" + i);
//        }

        User bob = new User(1, "bob");
        User alice = new User(2, "alice");
        User eve = new User(3, "eve");
        User charlie = new User(4, "charlie");

        MyLinkedList<User> collection = new MyLinkedList<>();
        collection.add(bob);
        collection.add(alice);
        collection.add(eve);
        collection.add(charlie);

        System.out.println("collection = " + collection);
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
        System.out.println("collection.get(3) = " + collection.get(3));
        System.out.println("collection.size() = " + collection.size());
        collection.remove(3);
        System.out.println("collection after removal = " + collection);
        System.out.println("collection.size() = " + collection.size());
        collection.clear();
        System.out.println("collection after clear = " + collection);
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.isEmpty() = " + collection.isEmpty());

    }

}