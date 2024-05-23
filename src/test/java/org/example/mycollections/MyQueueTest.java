package org.example.mycollections;

import org.example.customclass.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest {

    private MyQueue<String> cats;
    private MyQueue<Integer> numbers;
    private MyQueue<User> users;

    User bob = new User(1, "bob");
    User alice = new User(2, "alice");
    User eve = new User(3, "eve");
    User charlie = new User(4, "charlie");
    User frank = new User(1, "bob");

    @BeforeEach
    void setUp() {
        cats = new MyQueue<>();
        numbers = new MyQueue<>();
        users = new MyQueue<>();
    }

    // Testing MyQueue with String

    @Test
    void testAddWithString() {
        String expectedCatsColleltion = "[bengal, siamese, british shorthair, ragdoll, birman]";

        Assertions.assertTrue(cats.isEmpty());
        cats.add("bengal");
        Assertions.assertFalse(cats.isEmpty());
        Assertions.assertEquals("bengal", cats.peek());
        cats.add("siamese");
        cats.add("british shorthair");
        cats.add("ragdoll");
        cats.add("birman");
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
        Assertions.assertEquals(5, cats.size());
    }

    @Test
    void testPeekWithString() {
        cats.add("bengal");
        Assertions.assertEquals("bengal", cats.peek());
        Assertions.assertEquals(1, cats.size());
        cats.add("siamese");
        Assertions.assertEquals("bengal", cats.peek());
        Assertions.assertEquals(2, cats.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithString() {
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> cats.peek());
    }

    @Test
    void testPollWithString() {
        String expectedCatsColleltion = "[siamese, british shorthair]";

        cats.add("bengal");
        cats.add("siamese");
        cats.add("british shorthair");
        cats.poll();
        Assertions.assertEquals(2, cats.size());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    void testPollThrowsIllegalStateExceptionIfEmptyWithString() {
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> cats.poll());
        cats.add("bengal");
        cats.poll();
        Assertions.assertThrows(IllegalStateException.class, () -> cats.poll());
    }

    @Test
    void testResizeWithString() {
        // adding elements to exceed capacity
        int initialCapacity = 10;
        for (int i = 0; i < initialCapacity + 1; i++) {
            cats.add("meow" + i);
        }
        // check if resize is correct
        Assertions.assertEquals(initialCapacity + 1, cats.size());

        //check if all elements are correctly accessible
        for (int i = 0; i < initialCapacity + 1; i++) {
            Assertions.assertEquals("meow" + i, cats.poll());
        }
        Assertions.assertTrue(cats.isEmpty());
    }

    @Test
    void testSizeWithString() {
        Assertions.assertEquals(0, cats.size());
        cats.add("bengal");
        Assertions.assertEquals(1, cats.size());
        cats.add("siamese");
        cats.add("british shorthair");
        Assertions.assertEquals(3, cats.size());
    }

    @Test
    void testClearWithString() {
        String expectedCatsColleltion = "[]";

        cats.add("siamese");
        cats.add("british shorthair");
        cats.add("ragdoll");
        cats.add("birman");
        Assertions.assertEquals(4, cats.size());
        cats.clear();
        Assertions.assertEquals(0, cats.size());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    void testIsEmptyWithString() {
        String expectedEmptyCatsColleltion = "[]";
        String expectedCatsColleltion = "[siamese]";

        cats = new MyQueue<>();
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertTrue(expectedEmptyCatsColleltion.equals(cats.toString()));
        cats.add("siamese");
        Assertions.assertFalse(cats.isEmpty());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    //Testing MyQueue with Integer

    @Test
    void testAddWithInteger() {
        String expectedNumbersCollection = "[12, 15, 243, 233, 75]";

        Assertions.assertTrue(numbers.isEmpty());
        numbers.add(12);
        Assertions.assertFalse(numbers.isEmpty());
        Assertions.assertEquals(12, numbers.peek());
        numbers.add(15);
        numbers.add(243);
        numbers.add(233);
        numbers.add(75);
        Assertions.assertTrue(expectedNumbersCollection.equals(numbers.toString()));
        Assertions.assertEquals(5, numbers.size());
    }

    @Test
    void testPeekWithInteger() {
        numbers.add(0);
        Assertions.assertEquals(0, numbers.peek());
        Assertions.assertEquals(1, numbers.size());
        numbers.add(1);
        Assertions.assertEquals(0, numbers.peek());
        Assertions.assertEquals(2, numbers.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithNumbers() {
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.peek());
    }

    @Test
    void testPollWithInteger() {
        String expectedCatsColleltion = "[123, 754]";

        numbers.add(42);
        numbers.add(123);
        numbers.add(754);
        numbers.poll();
        Assertions.assertEquals(2, numbers.size());
        Assertions.assertTrue(expectedCatsColleltion.equals(numbers.toString()));
    }

    @Test
    void testPollThrowsIllegalStateExceptionIfEmptyWithInteger() {
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.poll());
        numbers.add(42);
        numbers.poll();
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.poll());
    }

    @Test
    void testResizeWithInteger() {
        int initialCapacity = 10;
        for (int i = 0; i < initialCapacity + 1; i++) {
            numbers.add(i);
        }

        Assertions.assertEquals(initialCapacity + 1, numbers.size());

        for (int i = 0; i < initialCapacity + 1; i++) {
            Assertions.assertEquals(i, numbers.poll());
        }
        Assertions.assertTrue(numbers.isEmpty());
    }

    @Test
    void testSizeWithInteger() {
        Assertions.assertEquals(0, numbers.size());
        numbers.add(42);
        Assertions.assertEquals(1, numbers.size());
        numbers.add(1);
        numbers.add(2);
        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    void testClearWithInteger() {
        String expectedNumbersColleltion = "[]";

        numbers.add(345);
        numbers.add(3434);
        numbers.add(845);
        numbers.add(-46);
        Assertions.assertEquals(4, numbers.size());
        numbers.clear();
        Assertions.assertEquals(0, numbers.size());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    @Test
    void testIsEmptyWithInteger() {
        String expectedEmptyNumbersColleltion = "[]";
        String expectedNumbersColleltion = "[42]";

        numbers = new MyQueue<>();
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertTrue(expectedEmptyNumbersColleltion.equals(numbers.toString()));
        numbers.add(42);
        Assertions.assertFalse(numbers.isEmpty());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    //Testing MyQueue with User class

    @Test
    void testAddWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [3 - eve], [4 - charlie], [1 - bob]]";

        Assertions.assertTrue(users.isEmpty());
        users.add(bob);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals(bob, users.peek());
        users.add(alice);
        Assertions.assertEquals(bob, users.peek());
        users.add(eve);
        users.add(charlie);
        users.add(frank);
        Assertions.assertTrue(expectedUsersCollection.equals(users.toString()));
        Assertions.assertEquals(5, users.size());
    }

    @Test
    void tesPeekWithUser() {
        users.add(bob);
        Assertions.assertEquals(bob, users.peek());
        Assertions.assertEquals(1, users.size());
        users.add(alice);
        Assertions.assertEquals(bob, users.peek());
        Assertions.assertEquals(2, users.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithUsers() {
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> users.peek());
    }

    @Test
    void testPollWithUser() {
        String expectedUsersCollection = "[[2 - alice], [3 - eve], [4 - charlie]]";

        users.add(bob);
        users.add(alice);
        users.add(eve);
        users.add(charlie);
        users.poll();
        Assertions.assertEquals(3, users.size());
        Assertions.assertTrue(expectedUsersCollection.equals(users.toString()));
    }

    @Test
    void testPollThrowsIllegalStateExceptionIfEmptyWithUser() {
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> users.poll());
        users.add(alice);
        users.poll();
        Assertions.assertThrows(IllegalStateException.class, () -> users.poll());
    }

    @Test
    void testSizeWithUser() {
        Assertions.assertEquals(0, users.size());
        users.add(bob);
        Assertions.assertEquals(1, users.size());
        users.add(alice);
        users.add(eve);
        Assertions.assertEquals(3, users.size());
    }

    @Test
    void testClearWithUsers() {
        String expectedUsersColleltion = "[]";

        users.add(bob);
        users.add(alice);
        users.add(eve);
        users.add(frank);
        Assertions.assertEquals(4, users.size());
        users.clear();
        Assertions.assertEquals(0, users.size());
        Assertions.assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

    @Test
    void testIsEmptyWithUsers() {
        String expectedEmptyUsersColleltion = "[]";
        String expectedUsersColleltion = "[[1 - bob]]";

        users = new MyQueue<>();
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertTrue(expectedEmptyUsersColleltion.equals(users.toString()));
        users.add(bob);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

}