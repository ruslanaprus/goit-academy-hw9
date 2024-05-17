package org.example;

public class User {
    String name;
    int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + " - " + name + "]";
    }
}
