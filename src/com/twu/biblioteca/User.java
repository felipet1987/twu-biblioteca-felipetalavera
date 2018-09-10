package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final String phone;
    private String number;

    public User(String number, String name, String email, String phone) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getNumber() {
        return this.number;
    }
}
