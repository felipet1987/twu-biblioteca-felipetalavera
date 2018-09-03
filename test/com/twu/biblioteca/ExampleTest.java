package com.twu.biblioteca;


import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca";
    public static final String SPACE = "\n";

    @Test
    public void test() {
        assertEquals(1, 1);
    }


    @Test
    public void WelcomeMessage() {


        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Librarian l = new Librarian();


        l.sendWelcome();


        String salida = outContent.toString();
        assertEquals(WELCOME_TO_BIBLIOTECA + SPACE, salida);



    }

}
