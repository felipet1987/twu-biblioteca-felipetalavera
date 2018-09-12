package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void login() {
        UserRepository repo = new FakeUserRepository();
        UserService service = new ListUserService(repo);

        service.login("123-4567","password");
        User u = service.getLoggedUser();
        assertEquals("123-4567",u.getNumber());
        assertEquals("Felipe",u.getName());
    }
}
