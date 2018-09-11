package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

public interface UserRepository {


    User findByNumber(String number);

    boolean login(String number, String password);

    void logout(String number);
}
