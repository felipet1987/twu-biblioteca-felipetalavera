package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

public class FakeUserService implements UserService {
    private User loggedUser;

    @Override
    public boolean login(String number, String password) {

        this.loggedUser = new User(number,"","","","");
        return true;
    }

    @Override
    public User getLoggedUser() {
        return this.loggedUser;
    }
}
