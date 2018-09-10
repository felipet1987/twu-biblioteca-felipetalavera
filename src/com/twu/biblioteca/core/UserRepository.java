package com.twu.biblioteca.core;

import com.twu.biblioteca.User;

public interface UserRepository {


    User findByNumber(String number);

    boolean login(String number, String password);

    void logout(String number);
}
