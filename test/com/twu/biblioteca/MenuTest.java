package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    OutputPort out;
    AppMenu menu;

    @Before
    public void setUp() {
        out = new TestOutput();
        InputPort in = new TestInput();
        menu = new ListMenu(in, out);

    }


    @Test
    public void WelcomeMessage() {
        menu.showWelcome();
        List<String> stream = out.getOutput();
        assertEquals("Welcome", stream.get(0));
    }


}
