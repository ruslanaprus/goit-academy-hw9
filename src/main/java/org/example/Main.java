package org.example;

import org.example.mycollections.MyArrayList;

import static java.util.Collections.swap;

public class Main {

    public static void main(String[] args) {

//        MyArrayList<String> collection = new MyArrayList<>();
//
//        for (int i = 0; collection.size() <= 20; i++){
//            collection.add("meow" + i);
//        }

        User bob = new User(1, "bob");
        User alice = new User(2, "alice");
        User eve = new User(3, "eve");
        User charlie = new User(4, "charlie");

        MyArrayList<User> collection = new MyArrayList<>();
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