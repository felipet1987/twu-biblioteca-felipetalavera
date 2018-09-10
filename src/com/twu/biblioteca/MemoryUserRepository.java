package com.twu.biblioteca;

import com.twu.biblioteca.core.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository implements UserRepository {

    private List<User> users;

    public MemoryUserRepository() {
        users = new ArrayList<>();

        users.add(new User("123-4567", "Felipe","correo@mail.cl","+56-991234567"));


    }


    @Override
    public User findByNumber(String number) {
        for (User u : users) {
            if (u.getNumber().equals(number)) {
                return u;
            }
        }

        return new User("", "", "", "");
    }
}
