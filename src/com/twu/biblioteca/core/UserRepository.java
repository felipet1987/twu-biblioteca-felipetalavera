package com.twu.biblioteca.core;

import com.twu.biblioteca.User;

public interface UserRepository {


    User findByNumber(String number);
}
