package org.example.mycollections;

import org.example.customclass.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<String> cats;
    private MyStack<Integer> numbers;
    private MyStack<User> users;

    User bob = new User(1, "bob");
    User alice = new User(2, "alice");
    User eve = new User(3, "eve");
    User charlie = new User(4, "charlie");
    User frank = new User(1, "bob");

    @BeforeEach
    void setUp() {
        cats = new MyStack<>();
        numbers = new MyStack<>();
        users = new MyStack<>();
    }

    // Testing MyStack with String

    @Test
    void testAddWithString() {
        String expectedCatsColleltion = "[bengal, siamese, british shorthair, ragdoll, birman]";

        assertTrue(cats.isEmpty());
        cats.push("bengal");
        assertFalse(cats.isEmpty());
        assertEquals("bengal", cats.peek());
        cats.push("siamese");
        cats.push("british shorthair");
        cats.push("ragdoll");
        cats.push("birman");
        assertEquals("birman", cats.peek());
        assertTrue(expectedCatsColleltion.equals(cats.toString()));
        assertEquals(5, cats.size());
    }

    @Test
    void testPeekWithString() {
        cats.push("bengal");
        Assertions.assertEquals("bengal", cats.peek());
        Assertions.assertEquals(1, cats.size());
        cats.push("siamese");
        cats.push("ragdoll");
        Assertions.assertEquals("ragdoll", cats.peek());
        Assertions.assertEquals(3, cats.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithString() {
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> cats.peek());
    }

    @Test
    void testPopWithString() {
        String expectedCatsColleltion = "[bengal, siamese]";

        cats.push("bengal");
        cats.push("siamese");
        cats.push("british shorthair");
        cats.pop();
        assertEquals(2, cats.size());
        assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    void testPopThrowsIllegalStateExceptionIfEmptyWithString() {
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> cats.pop());
        cats.push("bengal");
        cats.pop();
        Assertions.assertThrows(IllegalStateException.class, () -> cats.pop());
    }

    @Test
    void testRemoveWithString() {
        String expectedCatsColleltion = "[bengal, british shorthair]";

        cats.push("bengal");
        cats.push("siamese");
        cats.push("british shorthair");
        cats.remove(1);
        Assertions.assertEquals(2, cats.size());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    void testRemoveThrowsIndexOutOfBoundsExceptionWithString() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(0));
        cats.push("bengal");
        cats.push("siamese");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(-1));
    }

    @Test
    void testResizeContractionWithString() {
        int initialCapacity = 10;

        for (int i = 0; i < initialCapacity + 1; i++) {
            cats.push("meow" + i);
        }

        // Pop elements to reduce the size below one quarter of the capacity
        for (int i = 0; i < initialCapacity - initialCapacity / 4; i++) {
            cats.pop();
        }

        // Check if the size is correctly updated
        assertEquals(initialCapacity / 4 + 1, cats.size());

        // Check if all elements are correctly accessible
        for (int i = initialCapacity / 4; i >= 0 ; i--) {
            Assertions.assertEquals("meow" + i, cats.pop());
        }
        Assertions.assertTrue(cats.isEmpty());
    }

    @Test
    void testSizeWithString() {
        Assertions.assertEquals(0, cats.size());
        cats.push("bengal");
        Assertions.assertEquals(1, cats.size());
        cats.push("siamese");
        cats.push("british shorthair");
        Assertions.assertEquals(3, cats.size());
    }

    @Test
    void testClearWithString() {
        String expectedCatsColleltion = "[]";

        cats.push("siamese");
        cats.push("british shorthair");
        cats.push("ragdoll");
        cats.push("birman");
        assertEquals(4, cats.size());
        cats.clear();
        assertEquals(0, cats.size());
        assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    void testIsEmptyWithString() {
        String expectedEmptyCatsColleltion = "[]";
        String expectedCatsColleltion = "[siamese]";

        cats = new MyStack<>();
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertTrue(expectedEmptyCatsColleltion.equals(cats.toString()));
        cats.push("siamese");
        Assertions.assertFalse(cats.isEmpty());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    //Testing MyStack with Integer

    @Test
    void testAddWithInteger() {
        String expectedNumbersCollection = "[12, 15, 243, 233, 75]";

        assertTrue(numbers.isEmpty());
        numbers.push(12);
        assertFalse(numbers.isEmpty());
        assertEquals(12, numbers.peek());
        numbers.push(15);
        numbers.push(243);
        numbers.push(233);
        numbers.push(75);
        assertEquals(75, numbers.peek());
        assertTrue(expectedNumbersCollection.equals(numbers.toString()));
        assertEquals(5, numbers.size());
    }

    @Test
    void testPeekWithInteger() {
        numbers.push(0);
        Assertions.assertEquals(0, numbers.peek());
        Assertions.assertEquals(1, numbers.size());
        numbers.push(1);
        numbers.push(42);
        Assertions.assertEquals(42, numbers.peek());
        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithNumbers() {
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.peek());
    }

    @Test
    void testPopWithInteger() {
        String expectedCatsColleltion = "[42, 123]";

        numbers.push(42);
        numbers.push(123);
        numbers.push(754);
        numbers.pop();
        assertEquals(2, numbers.size());
        assertTrue(expectedCatsColleltion.equals(numbers.toString()));
    }

    @Test
    void testPopThrowsIllegalStateExceptionIfEmptyWithInteger() {
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.pop());
        numbers.push(42);
        numbers.pop();
        Assertions.assertThrows(IllegalStateException.class, () -> numbers.pop());
    }

    @Test
    void testRemoveWithInteger() {
        String expectedNumbersColleltion = "[1, 2]";

        numbers.push(0);
        numbers.push(1);
        numbers.push(2);
        numbers.remove(0);
        Assertions.assertEquals(2, numbers.size());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    @Test
    void testRemoveThrowsIndexOutOfBoundsExceptionWithInteger() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(0));
        numbers.push(0);
        numbers.push(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(-1));
    }

    @Test
    void testResizeWithInteger() {
        int initialCapacity = 10;
        for (int i = 0; i < initialCapacity + 1; i++) {
            numbers.push(i);
        }

        Assertions.assertEquals(initialCapacity + 1, numbers.size());

        for (int i = initialCapacity; i >= 0; i--) {
            Assertions.assertEquals(i, numbers.pop());
        }
        Assertions.assertTrue(numbers.isEmpty());
    }

    @Test
    void testSizeWithInteger() {
        assertEquals(0, numbers.size());
        numbers.push(42);
        assertEquals(1, numbers.size());
        numbers.push(1);
        numbers.push(2);
        assertEquals(3, numbers.size());
    }

    @Test
    void testClearWithInteger() {
        String expectedNumbersColleltion = "[]";

        numbers.push(345);
        numbers.push(3434);
        numbers.push(845);
        numbers.push(-46);
        assertEquals(4, numbers.size());
        numbers.clear();
        assertEquals(0, numbers.size());
        assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    @Test
    void testIsEmptyWithInteger() {
        String expectedEmptyNumbersColleltion = "[]";
        String expectedNumbersColleltion = "[42]";

        numbers = new MyStack<>();
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertTrue(expectedEmptyNumbersColleltion.equals(numbers.toString()));
        numbers.push(42);
        Assertions.assertFalse(numbers.isEmpty());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    //Testing MyStack with User class

    @Test
    void testAddWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [3 - eve], [4 - charlie], [1 - bob]]";

        assertTrue(users.isEmpty());
        users.push(bob);
        assertFalse(users.isEmpty());
        assertEquals(bob, users.peek());
        users.push(alice);
        users.push(eve);
        users.push(charlie);
        users.push(frank);
        assertEquals(frank, users.peek());
        assertTrue(expectedUsersCollection.equals(users.toString()));
        assertEquals(5, users.size());
    }

    @Test
    void tesPeekWithUser() {
        users.push(bob);
        Assertions.assertEquals(bob, users.peek());
        Assertions.assertEquals(1, users.size());
        users.push(alice);
        users.push(eve);
        Assertions.assertEquals(eve, users.peek());
        Assertions.assertEquals(3, users.size());
    }

    @Test
    void testPeekThrowsIllegalStateExceptionIfEmptyWithUsers() {
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> users.peek());
    }

    @Test
    void testPopWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [3 - eve]]";

        users.push(bob);
        users.push(alice);
        users.push(eve);
        users.push(charlie);
        users.pop();
        assertEquals(3, users.size());
        assertTrue(expectedUsersCollection.equals(users.toString()));
    }

    @Test
    void testPopThrowsIllegalStateExceptionIfEmptyWithUser() {
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> users.pop());
        users.push(alice);
        users.pop();
        Assertions.assertThrows(IllegalStateException.class, () -> users.pop());
    }

    @Test
    void testRemoveWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [4 - charlie]]";

        users.push(bob);
        users.push(alice);
        users.push(eve);
        users.push(charlie);
        users.remove(2);
        Assertions.assertEquals(3, users.size());
        Assertions.assertTrue(expectedUsersCollection.equals(users.toString()));
    }

    @Test
    public void testRemoveThrowsIndexOutOfBoundsExceptionWithUser() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(0));
        users.push(bob);
        users.push(alice);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(-1));
    }

    @Test
    void testSizeWithUser() {
        assertEquals(0, users.size());
        users.push(bob);
        assertEquals(1, users.size());
        users.push(alice);
        users.push(eve);
        assertEquals(3, users.size());
    }

    @Test
    void testClearWithUsers() {
        String expectedUsersColleltion = "[]";

        users.push(bob);
        users.push(alice);
        users.push(eve);
        users.push(frank);
        assertEquals(4, users.size());
        users.clear();
        assertEquals(0, users.size());
        assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

    @Test
    void testIsEmptyWithUsers() {
        String expectedEmptyUsersColleltion = "[]";
        String expectedUsersColleltion = "[[1 - bob]]";

        users = new MyStack<>();
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertTrue(expectedEmptyUsersColleltion.equals(users.toString()));
        users.push(bob);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

}