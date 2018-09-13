package com.twu.biblioteca;

import com.twu.biblioteca.mocks.FakeUserRepository;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.ListUserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void login() {
        UserRepository repo = new FakeUserRepository();
        UserService service = new ListUserService(repo);

        assertEquals(true,service.login("123-4567","password"));
        User u = service.getLoggedUser();
        assertEquals("123-4567",u.getNumber());
        assertEquals("Felipe",u.getName());
    }
}
