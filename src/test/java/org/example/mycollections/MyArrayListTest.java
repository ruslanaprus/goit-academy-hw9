package org.example.mycollections;

import org.example.customclass.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class MyArrayListTest {

    private MyArrayList<String> cats;
    private MyArrayList<Integer> numbers;
    private MyArrayList<User> users;

    User bob = new User(1, "bob");
    User alice = new User(2, "alice");
    User eve = new User(3, "eve");
    User charlie = new User(4, "charlie");
    User frank = new User(1, "bob");

    @BeforeEach
    void setUp() {
        cats = new MyArrayList<>();
        numbers = new MyArrayList<>();
        users = new MyArrayList<>();
        cats.add("bengal");
        cats.add("siamese");
        cats.add("british shorthair");
        cats.add("ragdoll");
        cats.add("birman");
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        users.add(bob);
        users.add(alice);
        users.add(eve);
        users.add(charlie);
        users.add(frank);
    }

    @Test
    void testAdd() {
        String expectedCatsColleltion = "[bengal, siamese, british shorthair, ragdoll, birman]";
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
        Assertions.assertEquals(5, cats.size());
        String expectedNumbersCollection = "[0, 1, 2, 3, 4]";
        Assertions.assertTrue(expectedNumbersCollection.equals(numbers.toString()));
        Assertions.assertEquals(5, numbers.size());
        String expectedUsesrsCollection = "[[1 - bob], [2 - alice], [3 - eve], [4 - charlie], [1 - bob]]";
        Assertions.assertTrue(expectedUsesrsCollection.equals(users.toString()));
        Assertions.assertEquals(5, users.size());
    }

    @Test
    void testGet(){
        Assertions.assertEquals("bengal", cats.get(0));
        Assertions.assertEquals("siamese", cats.get(1));
        Assertions.assertEquals("birman", cats.get(4));
        Assertions.assertEquals(0, numbers.get(0));
        Assertions.assertEquals(1, numbers.get(1));
        Assertions.assertEquals(4, numbers.get(4));
        Assertions.assertEquals(bob, users.get(0));
        Assertions.assertEquals(alice, users.get(1));
        Assertions.assertEquals(frank, users.get(4));
        Assertions.assertThrows(RuntimeException.class, () -> {
            Integer.parseInt("Index out of range");
        });
    }

    @Test
    void testSize() {
        Assertions.assertEquals(5, cats.size());
        Assertions.assertEquals(5, numbers.size());
        Assertions.assertEquals(5, users.size());
    }

    @Test
    void testRemove() {
        cats.remove(1);
        Assertions.assertEquals(4, cats.size());
        Assertions.assertEquals("british shorthair", cats.get(1));
        numbers.remove(0);
        Assertions.assertEquals(4, numbers.size());
        Assertions.assertEquals(1, numbers.get(0));
        users.remove(3);
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals(frank, users.get(3));
        Assertions.assertThrows(RuntimeException.class, () -> {
            Integer.parseInt("Index out of range");
        });

    }

    @Test
    void testClear() {
        cats.clear();
        numbers.clear();
        users.clear();
        Assertions.assertEquals(0, cats.size());
        Assertions.assertEquals(0, numbers.size());
        Assertions.assertEquals(0, users.size());
    }

    @Test
    void testIsEmpty() {
        cats = new MyArrayList<>();
        numbers = new MyArrayList<>();
        users = new MyArrayList<>();
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertTrue(users.isEmpty());
    }
}