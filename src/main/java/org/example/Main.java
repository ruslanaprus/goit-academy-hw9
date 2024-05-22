package org.example;

import org.example.customclass.User;
import org.example.mycollections.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        MyHashMap<String, Integer> collection = new MyHashMap<>(5);
//        collection.put("one", 1);
//        collection.put("two", 2);
//        collection.put("three", 3);
//        collection.put("four", 4);
//        collection.put("five", 5);
//        collection.put("six", 6);
//        collection.put("seven", 7);
//        collection.put("seven", 7);
//        System.out.println("collection.isEmpty() = " + collection.isEmpty());
//
//        for (int i = 0; collection.size() <= 20; i++) {
//            collection.put("meow" + i);
//        }

        User bob = new User(1, "bob");
        User alice = new User(2, "alice");
        User eve = new User(3, "eve");
        User charlie = new User(4, "charlie");
        User frank = new User(1, "bob");


  //      HashMap<User, String> collection = new HashMap();
        MyHashMap<User, String> collection = new MyHashMap();
        collection.put(bob, "developer");
        collection.put(alice, "developer");
        collection.put(eve, "manager");
        collection.put(charlie, "ceo");
        collection.put(frank, "manager"); // this will rewrite bob's position

        System.out.println("collection = " + collection);
//        System.out.println("collection.isEmpty() = " + collection.isEmpty());
        System.out.println("collection.get(bob) = " + collection.get(bob));
        System.out.println("collection.size() = " + collection.size());
        collection.remove(eve);
        System.out.println("collection after removal = " + collection);
        System.out.println("collection.size() = " + collection.size());
        collection.clear();
        System.out.println("collection after clear = " + collection);
        System.out.println("collection.size() = " + collection.size());

    }

}