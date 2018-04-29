package com.codecool.Model;

import java.util.Objects;

public class User {
    private int id = -1;
    private String email;
    private String name = null;
    private String passw;


    public User(int id, String email, String name, String passw) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.passw = passw;
    }

    public User(String email, String passw) {
        this.email = email;
        this.passw = passw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(passw, user.passw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, passw);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + passw + '\'' +
                '}';
    }
}
