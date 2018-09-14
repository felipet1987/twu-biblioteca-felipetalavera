package com.twu.biblioteca;

import com.twu.biblioteca.app.AppMenu;
import com.twu.biblioteca.app.MainController;
import com.twu.biblioteca.mocks.TestInput;
import com.twu.biblioteca.mocks.TestOutput;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class mainTest {


    private MainController mainController;
    private InputPort in;
    private OutputPort out;
    private AppMenu menu;


    @Before
    public void setUp() {
        in = new TestInput();
        out = new TestOutput();
        menu = new FakeMenu(in, out);
        mainController = new MainController(menu);
    }


    @Test
    public void ShouldAskLoginUntilCorrect() {
        List<String> data = new ArrayList<>();
        data.add("123-456");
        data.add("password");
        data.add("123-4567");
        data.add("password");
        in.setInput(data);


        mainController.start();


        List<String> stream = out.getOutput();

        assertEquals(globals.ENTER_LIBRARY_NUMBER, stream.get(0));
        assertEquals(globals.ENTER_PASSWORD, stream.get(1));
        assertEquals(globals.ENTER_LIBRARY_NUMBER, stream.get(2));
        assertEquals(globals.ENTER_PASSWORD, stream.get(3));
        assertEquals(globals.WELCOME, stream.get(4));


    }

    @Test
    public void whenEnterZeroShouldShowBookMenu() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_AN_OPTION, stream.get(0));
        assertEquals(globals.BOOK_HEADER, stream.get(1));

    }



}
