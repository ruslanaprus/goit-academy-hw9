package org.example.mycollections;

import org.example.customclass.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
    private MyLinkedList<String> cats;
    private MyLinkedList<Integer> numbers;
    private MyLinkedList<User> users;

    User bob = new User(1, "bob");
    User alice = new User(2, "alice");
    User eve = new User(3, "eve");
    User charlie = new User(4, "charlie");
    User frank = new User(1, "bob");

    @BeforeEach
    void setUp() {
        cats = new MyLinkedList<>();
        numbers = new MyLinkedList<>();
        users = new MyLinkedList<>();
    }

    // Testing MyLinkedList with String

    @Test
    void testAddWithString() {
        String expectedCatsColleltion = "[bengal, siamese, british shorthair, ragdoll, birman]";

        Assertions.assertTrue(cats.isEmpty());
        cats.add("bengal");
        Assertions.assertFalse(cats.isEmpty());
        Assertions.assertEquals("bengal", cats.get(0));
        cats.add("siamese");
        cats.add("british shorthair");
        cats.add("ragdoll");
        cats.add("birman");
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
        Assertions.assertEquals(5, cats.size());
    }

    @Test
    void testGetWithString() {
        cats.add("bengal");
        cats.add("siamese");
        cats.add("british shorthair");
        Assertions.assertEquals("bengal", cats.get(0));
        Assertions.assertEquals("siamese", cats.get(1));
        Assertions.assertEquals("british shorthair", cats.get(2));
    }

    @Test
    public void testGetThrowsIndexOutOfBoundsExceptionWithString() {
        // For empty list
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.get(-1));

        // After adding some elements
        cats.add("bengal");
        cats.add("siamese");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.get(-1));
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
    void testRemoveWithString() {
        String expectedCatsColleltion = "[bengal, british shorthair]";

        cats.add("bengal");
        cats.add("siamese");
        cats.add("british shorthair");
        cats.remove(1);
        Assertions.assertEquals(2, cats.size());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    @Test
    public void testRemoveThrowsIndexOutOfBoundsExceptionWithString() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(0));
        cats.add("bengal");
        cats.add("siamese");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> cats.remove(-1));
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

        cats = new MyLinkedList<>();
        Assertions.assertTrue(cats.isEmpty());
        Assertions.assertTrue(expectedEmptyCatsColleltion.equals(cats.toString()));
        cats.add("siamese");
        Assertions.assertFalse(cats.isEmpty());
        Assertions.assertTrue(expectedCatsColleltion.equals(cats.toString()));
    }

    //Testing MyLinkedList with Integer

    @Test
    void testAddWithInteger() {
        String expectedNumbersCollection = "[0, 1, 2, 3, 4]";

        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Assertions.assertTrue(expectedNumbersCollection.equals(numbers.toString()));
        Assertions.assertEquals(5, numbers.size());
    }

    @Test
    void testGetWithInteger() {
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        Assertions.assertEquals(0, numbers.get(0));
        Assertions.assertEquals(1, numbers.get(1));
        Assertions.assertEquals(2, numbers.get(2));
    }

    @Test
    public void testGetThrowsIndexOutOfBoundsExceptionWithInteger() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(-1));
        numbers.add(0);
        numbers.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(-1));
    }

    @Test
    void testSizeWithInteger() {
        Assertions.assertEquals(0, numbers.size());
        numbers.add(0);
        numbers.add(1);
        Assertions.assertEquals(2, numbers.size());
        numbers.add(2);
        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    void testRemoveWithInteger() {
        String expectedNumbersColleltion = "[1, 2]";

        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.remove(0);
        Assertions.assertEquals(2, numbers.size());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    @Test
    public void testRemoveThrowsIndexOutOfBoundsExceptionWithInteger() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(0));
        numbers.add(0);
        numbers.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(-1));
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

        numbers = new MyLinkedList<>();
        Assertions.assertTrue(numbers.isEmpty());
        Assertions.assertTrue(expectedEmptyNumbersColleltion.equals(numbers.toString()));
        numbers.add(42);
        Assertions.assertFalse(numbers.isEmpty());
        Assertions.assertTrue(expectedNumbersColleltion.equals(numbers.toString()));
    }

    //Testing MyLinkedList with User class

    @Test
    void testAddWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [3 - eve], [4 - charlie], [1 - bob]]";

        users.add(bob);
        users.add(alice);
        users.add(eve);
        users.add(charlie);
        users.add(frank);
        Assertions.assertTrue(expectedUsersCollection.equals(users.toString()));
        Assertions.assertEquals(5, users.size());
    }

    @Test
    void testGetWithUser() {
        users.add(bob);
        users.add(alice);
        users.add(eve);
        Assertions.assertEquals(bob, users.get(0));
        Assertions.assertEquals(alice, users.get(1));
        Assertions.assertEquals(eve, users.get(2));
    }

    @Test
    public void testGetThrowsIndexOutOfBoundsExceptionWithUsers() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.get(-1));
        users.add(bob);
        users.add(alice);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(-1));
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
    void testRemoveWithUser() {
        String expectedUsersCollection = "[[1 - bob], [2 - alice], [4 - charlie]]";

        users.add(bob);
        users.add(alice);
        users.add(eve);
        users.add(charlie);
        users.remove(2);
        Assertions.assertEquals(3, users.size());
        Assertions.assertTrue(expectedUsersCollection.equals(users.toString()));
    }

    @Test
    public void testRemoveThrowsIndexOutOfBoundsExceptionWithUser() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(0));
        users.add(bob);
        users.add(alice);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> users.remove(-1));
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

        users = new MyLinkedList<>();
        Assertions.assertTrue(users.isEmpty());
        Assertions.assertTrue(expectedEmptyUsersColleltion.equals(users.toString()));
        users.add(bob);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

}