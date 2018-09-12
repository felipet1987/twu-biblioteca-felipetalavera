package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

public interface UserService {

    boolean login(String numnber, String password);

    User getLoggedUser();
}
