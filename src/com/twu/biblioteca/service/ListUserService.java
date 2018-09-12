package com.twu.biblioteca.service;

import com.twu.biblioteca.UserRepository;
import com.twu.biblioteca.UserService;
import com.twu.biblioteca.model.User;

public class ListUserService implements UserService {
    private final UserRepository repo;
    private User loggedUser;

    public ListUserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean login(String number, String password) {

        if(repo.login(number,password)){
            this.loggedUser = repo.findByNumber(number);
            return true;
        }
        return false;
    }

    @Override
    public User getLoggedUser() {
        return this.loggedUser;
    }
}
