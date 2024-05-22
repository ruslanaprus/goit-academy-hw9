package org.example.customclass;

import java.util.Objects;

public class User {
    private String name;
    private int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        return this.id == user.id && Objects.equals(this.name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "[" + id + " - " + name + "]";
    }
}
