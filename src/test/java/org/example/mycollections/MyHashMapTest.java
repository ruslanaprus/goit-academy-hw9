package org.example.mycollections;

import org.example.customclass.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

    private MyHashMap<String, Integer> cats;
    private MyHashMap<Integer, String> numbers;
    private MyHashMap<User, String> users;

    User bob = new User(1, "bob");
    User alice = new User(2, "alice");
    User eve = new User(3, "eve");
    User charlie = new User(4, "charlie");

    @BeforeEach
    void setUp() {
        cats = new MyHashMap<>();
        numbers = new MyHashMap<>();
        users = new MyHashMap<>();
    }

    // Testing MyHashMap with String as a Key

    @Test
    void testPutWithStringAsAKey() {
        Assertions.assertEquals(0, cats.size());
        cats.put("bengal", 1);
        Assertions.assertNotEquals(0, cats.size());
        Assertions.assertEquals(1, cats.get("bengal"));
    }

    @Test
    void testPutUpdateValueIfTheSameKeyWithStringAsAKey() {
        cats.put("siamese", 1);
        Assertions.assertNotEquals(0, cats.size());
        Assertions.assertEquals(1, cats.get("siamese"));
        cats.put("siamese", 2);
        Assertions.assertEquals(2, cats.get("siamese"));
        Assertions.assertEquals(1, cats.size());
    }

    @Test
    void testPutNullKey() {
        cats.put(null, -1);
        Assertions.assertEquals(1, cats.size());
        Assertions.assertEquals(-1, cats.get(null));
    }

    @Test
    void testPutNullValue() {
        cats.put("purr", null);
        Assertions.assertEquals(1, cats.size());
        Assertions.assertNull(cats.get("purr"));
    }

    @Test
    void testResizeWithStringAsAKey() {
        int initialCapacity = 16;

        for (int i = 0; i < initialCapacity + 1; i++) {
            cats.put("meow" + i, i);
        }
        Assertions.assertEquals(initialCapacity + 1, cats.size());

        for (int i = 0; i < initialCapacity + 1; i++) {
            Assertions.assertEquals(i, cats.get("meow" + i));
        }
    }

    @Test
    void testGetWithExistingStringAsAKey() {
        cats.put("bengal", 1);
        cats.put("siamese", 2);
        cats.put("british shorthair", 3);
        Assertions.assertEquals(1, cats.get("bengal"));
        Assertions.assertEquals(2, cats.get("siamese"));
        Assertions.assertEquals(3, cats.get("british shorthair"));
    }

    @Test
    void testGetNonExistentStringKey() {
        Assertions.assertNull(cats.get("meowww"));
    }

    @Test
    void testSizeWithStringAsAKey() {
        Assertions.assertEquals(0, cats.size());
        cats.put("bengal", 1);
        Assertions.assertEquals(1, cats.size());
        cats.put("siamese", 2);
        cats.put("british shorthair", 3);
        Assertions.assertEquals(3, cats.size());
    }

    @Test
    void testRemoveExistingKey() {
        cats.put("bengal", 1);
        cats.remove("bengal");
        Assertions.assertNull(cats.get("bengal"));
        Assertions.assertEquals(0, cats.size());
    }

    @Test
    void testRemoveNonExistentKey() {
        cats.put("bengal", 1);
        cats.remove("siamese");
        Assertions.assertEquals(1, cats.size());
        Assertions.assertEquals(1, cats.get("bengal"));
    }

    @Test
    void testRemoveNullKey() {
        cats.put(null, -1);
        cats.remove(null);
        Assertions.assertEquals(0, cats.size());
        Assertions.assertNull(cats.get(null));
    }

    @Test
    void testClearWithStringAsAKey() {
        cats.put("siamese", 2);
        cats.put("british shorthair", 3);
        cats.put("ragdoll", 4);
        cats.put("birman", 5);
        Assertions.assertEquals(4, cats.size());
        cats.clear();
        Assertions.assertEquals(0, cats.size());
    }

    // Testing MyHashMap with custom class User as a Key

    @Test
    void testPutWithUser() {

        users.put(bob, "developer");
        users.put(alice, "developer");
        users.put(eve, "manager");
        users.put(charlie, "ceo");
        Assertions.assertEquals(4, users.size());
    }

    @Test
    void testPutWithUserAsAKey() {
        Assertions.assertEquals(0, users.size());
        users.put(bob, "developer");
        Assertions.assertNotEquals(0, users.size());
        Assertions.assertEquals("developer", users.get(bob));
    }

    @Test
    void testPutUpdateValueIfTheSameKeyWithUserAsAKey() {
        users.put(bob, "developer");
        Assertions.assertNotEquals(0, users.size());
        Assertions.assertEquals("developer", users.get(bob));
        users.put(bob, "manager");
        Assertions.assertEquals("manager", users.get(bob));
        Assertions.assertEquals(1, users.size());
    }

    @Test
    void testEqualsFromUserClas() {
        User bob = new User(1, "bob");
        User frank = new User(1, "bob");

        Assertions.assertEquals(bob, frank);
        users.put(bob, "developer");
        Assertions.assertNotEquals(0, users.size());
        Assertions.assertEquals("developer", users.get(bob));
        users.put(frank, "ceo");
        //frank has same id as bob, hash for bob and frank will be the same
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals("ceo", users.get(bob));
    }

    @Test
    void testGetWithExistingUserAsAKey() {
        users.put(bob, "developer");
        users.put(alice, "developer");
        users.put(eve, "manager");
        Assertions.assertEquals("developer", users.get(bob));
        Assertions.assertEquals("developer", users.get(alice));
        Assertions.assertEquals("manager", users.get(eve));
    }

    @Test
    void testSizeWithUser() {
        Assertions.assertEquals(0, users.size());
        users.put(bob, "developer");
        Assertions.assertEquals(1, users.size());
        users.put(alice, "developer");
        users.put(eve, "manager");
        Assertions.assertEquals(3, users.size());
    }

    @Test
    void testRemoveExistingUserAsAKey() {
        users.put(bob, "developer");
        users.remove(bob);
        Assertions.assertNull(users.get(bob));
        Assertions.assertEquals(0, users.size());
    }

    @Test
    void testClearWithUsers() {
        String expectedUsersColleltion = "[]";

        users.put(bob, "developer");
        users.put(alice, "developer");
        users.put(eve, "manager");
        users.put(charlie, "ceo");
        Assertions.assertEquals(4, users.size());
        users.clear();
        Assertions.assertEquals(0, users.size());
        Assertions.assertTrue(expectedUsersColleltion.equals(users.toString()));
    }

}