package com.twu.biblioteca.mocks;

import com.twu.biblioteca.UserRepository;
import com.twu.biblioteca.model.User;

public class FakeUserRepository implements UserRepository {
    @Override
    public User findByNumber(String number) {
        return new User("123-4567","password","Felipe","","");
    }

    @Override
    public boolean login(String number, String password) {
        return true;
    }

    @Override
    public void logout(String number) {

    }
}
