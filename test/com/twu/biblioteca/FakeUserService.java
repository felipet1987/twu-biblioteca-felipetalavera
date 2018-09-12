package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

public class FakeUserService implements UserService {
    private User loggedUser;

    @Override
    public boolean login(String number, String password) {

        this.loggedUser = new User(number,"","","","");
        if(number == "123-456"){
            return false;
        }
        return true;
    }

    @Override
    public User getLoggedUser() {
        return this.loggedUser;
    }
}