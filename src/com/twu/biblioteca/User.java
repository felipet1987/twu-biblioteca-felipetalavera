package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final String phone;
    private String number;
    private String password;
    private boolean logged;

    User(String number, String password, String name, String email, String phone) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.logged = false;
    }

    String getName() {
        return this.name;
    }

    String getEmail() {
        return this.email;
    }

    String getPhone() {
        return this.phone;
    }

    String getNumber() {
        return this.number;
    }

    String getPassword() {
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
