package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    OutputPort out;
    InputPort in;
    AppMenu menu;
    UserService userService;
    BookService bookService;

    @Before
    public void setUp() {
        out = new TestOutput();
        in = new TestInput();
        userService = new FakeUserService();
        bookService = new FakeBookService();
        menu = new ListMenu(in, out,userService,bookService);

    }

    @Test
    public void succesfulLogin() {
        List<String> data = new ArrayList<>();
        data.add("123-4567");
        data.add("password");
        in.setInput(data);

        boolean logged = menu.login();
        List<String> stream = out.getOutput();
        assertEquals("enter library number", stream.get(0));
        assertEquals("enter password", stream.get(1));
        assertEquals(true,logged);
        
    }

    @Test
    public void unSuccesfulLogin() {
        List<String> data = new ArrayList<>();
        data.add("123-456");
        data.add("password");
        in.setInput(data);

        boolean logged = menu.login();
        List<String> stream = out.getOutput();
        assertEquals("enter library number", stream.get(0));
        assertEquals("enter password", stream.get(1));
        assertEquals(false, logged);

    }

    @Test
    public void WelcomeMessage() {
        menu.showWelcome();
        List<String> stream = out.getOutput();
        assertEquals("Welcome", stream.get(0));
    }

    @Test
    public void gettingUserInput() {

        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);
        String option = menu.waitForUser();
        List<String> stream = out.getOutput();
        assertEquals("please enter an option", stream.get(0));
        assertEquals("1",option);


    }

    @Test
    public void executeOption() {


        menu.executeOption("0");
        List<String> stream = out.getOutput();
        assertEquals("ID:NAME:AUTHOR:YEAR", stream.get(0));


    }


    @Test
    public void ShowBookMenu() {
        menu.showBookMenu();

        List<String> stream = out.getOutput();
        assertEquals("ID:NAME:AUTHOR:YEAR", stream.get(0));
        assertEquals("1:name:author:2000", stream.get(1));
        assertEquals("0 . return book", stream.get(2));
        assertEquals("1 . checkout book", stream.get(3));

    }





}
