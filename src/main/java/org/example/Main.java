package org.example;

import org.example.customclass.EmailAddress;
import org.example.customclass.User;
import org.example.mycollections.*;
import java.time.LocalDate;

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

//        EmailAddress bobsEmail = new EmailAddress(1234, bob, "active", LocalDate.of(2020, 1, 8), true);
//        EmailAddress bobsSecondEmail = new EmailAddress(1234, bob, "active", LocalDate.of(2020, 1, 8), true);
//        EmailAddress alicesEmail = new EmailAddress(321, alice, "active", LocalDate.of(2002, 3, 14), false);
//        EmailAddress evesEmail = new EmailAddress(987, eve, "active", LocalDate.of(2019, 12, 22), false);
//
//        MyHashMap<EmailAddress, String> collection = new MyHashMap(4);
//        collection.put(bobsEmail, "developer");
//        collection.put(alicesEmail, "developer");
//        collection.put(bobsSecondEmail, "manager");
//        collection.put(evesEmail, "ceo");

        MyHashMap<User, String> collection = new MyHashMap();
        collection.put(bob, "developer");
        collection.put(alice, "developer");
        collection.put(eve, "manager");
        collection.put(charlie, "ceo");
        collection.put(frank, "manager"); // this will rewrite bob's position

        System.out.println("collection = " + collection);
        System.out.println("collection.get(bob) = " + collection.get(bob));
        System.out.println("collection.size() = " + collection.size());
        collection.remove(bob);
        System.out.println("collection after removal = " + collection);
        System.out.println("collection.size() = " + collection.size());
        collection.clear();
        System.out.println("collection after clear = " + collection);
        System.out.println("collection.size() = " + collection.size());

    }

}