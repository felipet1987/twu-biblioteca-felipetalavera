package com.twu.biblioteca;

import com.twu.biblioteca.core.AppMenu;
import com.twu.biblioteca.core.InputPort;
import com.twu.biblioteca.core.MenuController;
import com.twu.biblioteca.core.OutputPort;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    public static final String INVALID_OPTION = "Invalid option";
    public static final String BOOK_HEADER = "ID:NAME:AUTHOR:YEAR";
    AppMenu menu;
    InputPort input;
    OutputPort output;
    MenuController controller;

    @Before
    public void setUp() throws Exception {

        menu = new FakeMenu();
        input = new TestInput();
        output = new TestOutput();
        controller = new MenuController(menu, input, output);

    }

    @Test
    public void whenShowMenuShouldShowWelcomeMessage() {


        controller.showMenu();
        List<String> out = ((TestOutput) output).getOutput();
        assertEquals("Welcome", out.get(0));


    }

    @Test
    public void shouldShowBooksList() {


        controller.showBooks();

        List<String> out = ((TestOutput) output).getOutput();

        assertEquals(BOOK_HEADER, out.get(0));
        assertEquals("1:name:author:2018", out.get(1));


    }


    @Test
    public void shouldShowOptionforBooksList() {
        controller.showBookOptions();

        List<String> out = ((TestOutput) output).getOutput();

        assertEquals("Choose an option", out.get(0));
        assertEquals("1 . return book", out.get(1));
        assertEquals("2 . checkout book", out.get(2));

    }

    @Test
    public void whenUserInputIsZeroShoouldShowBooks() {


        ((TestInput) input).setInput(0);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getOutput();
        assertEquals(BOOK_HEADER, out.get(1));


    }

    @Test
    public void SuccessfulCheckout() {


        ((TestInput) input).setInput(0);
        controller.checkout();
        List<String> out = ((TestOutput) output).getOutput();
        assertEquals("Thank you! Enjoy the book", out.get(0));

    }

    @Test
    public void UnSuccessfulCheckout() {


        ((TestInput) input).setInput(1);
        controller.checkout();
        List<String> out = ((TestOutput) output).getOutput();
        assertEquals("That book is not available.", out.get(0));

    }

    @Test
    public void SuccessfulReturn() {


        ((TestInput) input).setInput(0);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getOutput();
        assertEquals("Thank you for returning the book.", out.get(0));


    }

    @Test
    public void UnSuccessfulReturn() {


        ((TestInput) input).setInput(1);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getOutput();
        assertEquals("That is not a valid book to return.", out.get(0));


    }

    @Test
    public void invalidOption() {


        ((TestInput) input).setInput(-1);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getOutput();
        assertEquals(INVALID_OPTION, out.get(1));


    }

    @Test
    public void quit() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);
        controller.exit();
        assertEquals(-1, ((TestOutput) output).getExitStatus());

    }

}
