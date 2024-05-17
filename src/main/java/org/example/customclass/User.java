package org.example.customclass;

public class User {
    private String name;
    private int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + " - " + name + "]";
    }
}
