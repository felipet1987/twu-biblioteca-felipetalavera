package com.twu.biblioteca;

import com.twu.biblioteca.core.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    @Test
    public void shouldReturnUserInfo() {

        UserRepository repo = new MemoryUserRepository();
        User u = repo.findByNumber("123-4567");

        assertEquals(u.getNumber(), "123-4567");
        assertEquals(u.getName(), "Felipe");
        assertEquals(u.getEmail(), "correo@mail.cl");
        assertEquals(u.getPhone(), "+56-991234567");
    }

    @Test
    public void whenLoginShouldBeValid() {
        UserRepository repo = new MemoryUserRepository();


        assertEquals(true,repo.login("123-4567","password"));
        assertEquals(true,repo.findByNumber("123-4567").isLogged());
        assertEquals(false,repo.login("123-4567","pass"));
        assertEquals(false,repo.login("123-45","password"));


    }

    @Test
    public void whenLogoutShouldNotBeLogged() {
        UserRepository repo = new MemoryUserRepository();
        repo.logout("123-4567");
        assertEquals(false,repo.findByNumber("123-4567").isLogged());

    }
}
