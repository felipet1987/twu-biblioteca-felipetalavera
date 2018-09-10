package com.twu.biblioteca;

import com.twu.biblioteca.core.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    @Test
    public void shouldReturnUserInfo() {
        //name, email address and phone number
        UserRepository repo = new MemoryUserRepository();
        User u = repo.findByNumber("123-4567");

        assertEquals(u.getNumber(), "123-4567");
        assertEquals(u.getName(), "Felipe");
        assertEquals(u.getEmail(), "correo@mail.cl");
        assertEquals(u.getPhone(), "+56-991234567");
    }
}
