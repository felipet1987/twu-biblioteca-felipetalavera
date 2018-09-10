package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

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
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Welcome", out.get(0));


    }

    @Test
    public void showBooks() {


        controller.showBooks();

        List<String> out = ((TestOutput) output).getData();

        assertEquals("ID:NAME:AUTHOR:YEAR", out.get(0));
        assertEquals("1:name:author:2018", out.get(1));


    }

    @Test
    public void showBookOptions() {
        controller.showBookOptions();

        List<String> out = ((TestOutput) output).getData();

        assertEquals("Choose an option", out.get(0));
        assertEquals("1 . return book", out.get(1));
        assertEquals("2 . checkout book", out.get(2));

    }

    @Test
    public void choosingShowBooksOption() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);

        ((TestInput) input).setData(0);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getData();
        assertEquals("ID:NAME:AUTHOR:YEAR", out.get(1));


    }

    @Test
    public void SuccessfulCheckout() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);


        ((TestInput) input).setData(0);
        controller.checkout();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Thank you! Enjoy the book", out.get(0));

    }

    @Test
    public void UnSuccessfulCheckout() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);


        ((TestInput) input).setData(1);
        controller.checkout();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("That book is not available.", out.get(0));

    }

    @Test
    public void SuccessfulReturn() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);

        ((TestInput) input).setData(0);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Thank you for returning the book.", out.get(0));


    }

    @Test
    public void UnSuccessfulReturn() {
        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);

        ((TestInput) input).setData(1);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("That is not a valid book to return.", out.get(0));


    }

    @Test
    public void invalidOption() {

        AppMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        MenuController controller = new MenuController(menu, input, output);

        ((TestInput) input).setData(-1);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getData();
        assertEquals("Invalid option", out.get(1));


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
