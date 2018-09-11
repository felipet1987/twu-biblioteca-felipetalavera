package com.twu.biblioteca.model;

public class User {
    private final String name;
    private final String email;
    private final String phone;
    private String number;
    private String password;
    private boolean logged;

    public User(String number, String password, String name, String email, String phone) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.logged = false;
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

    public String getPassword() {
        return this.password;
    }

    public boolean isLogged() {
        return this.logged;
    }

    public void login() {
        this.logged = true;
    }

    public void logout() {
        this.logged = false;
    }
}
