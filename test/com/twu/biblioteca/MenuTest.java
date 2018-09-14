package com.twu.biblioteca;

import com.twu.biblioteca.app.AppMenu;
import com.twu.biblioteca.app.ListMenu;
import com.twu.biblioteca.mocks.*;
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
    MovieService movieService;

    @Before
    public void setUp() {
        out = new TestOutput();
        in = new TestInput();
        userService = new FakeUserService();
        bookService = new FakeBookService();
        movieService = new FakeMovieService();
        menu = new ListMenu(in, out, userService, bookService, movieService);
    }

    @Test
    public void showMainMenu() {
        menu.showMenu();

        List<String> stream = out.getOutput();
        mainMenuAppeared(stream, 0);
    }

    @Test
    public void succesfulLogin() {
        List<String> data = new ArrayList<>();
        data.add("123-4567");
        data.add("password");
        in.setInput(data);

        boolean logged = menu.login();

        List<String> stream = out.getOutput();
        assertEquals(globals.ENTER_LIBRARY_NUMBER, stream.get(0));
        assertEquals(globals.ENTER_PASSWORD, stream.get(1));
        assertEquals(true, logged);
    }

    @Test
    public void unSuccesfulLogin() {
        List<String> data = new ArrayList<>();
        data.add("123-456");
        data.add("password");
        in.setInput(data);

        boolean logged = menu.login();

        List<String> stream = out.getOutput();
        assertEquals(globals.ENTER_LIBRARY_NUMBER, stream.get(0));
        assertEquals(globals.ENTER_PASSWORD, stream.get(1));
        assertEquals(false, logged);
    }

    @Test
    public void WelcomeMessage() {
        menu.showWelcome();

        List<String> stream = out.getOutput();
        assertEquals(globals.WELCOME, stream.get(0));
    }

    @Test
    public void gettingUserInput() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        String option = menu.waitForUser();

        List<String> stream = out.getOutput();
        assertEquals(globals.PLEASE_ENTER_AN_OPTION, stream.get(0));
        assertEquals("1", option);
    }

    @Test
    public void executeOption() {
        menu.executeOption("0");

        List<String> stream = out.getOutput();
        assertEquals(globals.BOOK_HEADER, stream.get(0));
    }

    @Test
    public void invalidOption() {
        menu.executeOption("-1");

        List<String> stream = out.getOutput();
        assertEquals(globals.INVALID_OPTION, stream.get(0));
    }

    @Test
    public void showUserDetail() {
        List<String> data = new ArrayList<>();
        data.add("123-456");
        data.add("password");
        data.add("1");
        in.setInput(data);

        menu.login();
        menu.showUserDetails();


        List<String> stream = out.getOutput();
        assertEquals("name", stream.get(2));
        assertEquals("email", stream.get(3));
        assertEquals("phone", stream.get(4));
        assertEquals(globals.BACK_TO_MENU, stream.get(5));
        mainMenuAppeared(stream,6);



    }

    @Test
    public void showBookMenu() {
        menu.showBookMenu();

        List<String> stream = out.getOutput();
        bookMenuAppeared(stream, 0);
    }

    @Test
    public void showMovieMenu() {
        menu.showMovieMenu();

        List<String> stream = out.getOutput();

        movieMenuAppeared(stream, 0);
    }

    @Test
    public void showBookAndThenCheckout() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        menu.setCurrentOption("0");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        assertEquals(globals.PLEASE_ENTER_ID_OF_BOOK, stream.get(0));
        assertEquals(globals.THANK_YOU_ENJOY_THE_BOOK, stream.get(1));
    }

    @Test
    public void showBookAndThenUnSuccesfulCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("0");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        assertEquals(globals.PLEASE_ENTER_ID_OF_BOOK, stream.get(0));
        assertEquals(globals.THAT_BOOK_IS_NOT_AVAILABLE, stream.get(1));
    }

    @Test
    public void showMoviesAndThenCheckout() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        menu.setCurrentOption("1");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        assertEquals(globals.ENTER_ID_OF_MOVIE, stream.get(0));
        assertEquals(globals.THANK_YOU_ENJOY_THE_MOVIE, stream.get(1));
    }

    @Test
    public void showMoviesAndThenUnSeccesfulCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("1");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        assertEquals(globals.ENTER_ID_OF_MOVIE, stream.get(0));
        assertEquals(globals.THAT_MOVIE_IS_NOT_AVAILABLE, stream.get(1));
    }

    @Test
    public void showMoviesAndThenReturn() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        menu.setCurrentOption("1");
        menu.executeOption("0");

        List<String> stream = out.getOutput();
        assertEquals("1. movie2", stream.get(0));
        assertEquals("2. movie3", stream.get(1));
        assertEquals(globals.ENTER_ID_OF_MOVIE, stream.get(2));
        assertEquals(globals.THANK_YOU_FOR_RETURNING_THE_MOVIE, stream.get(3));
    }

    @Test
    public void showBooksAndThenReturn() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        menu.setCurrentOption("0");
        menu.executeOption("0");

        List<String> stream = out.getOutput();
        assertEquals("1. book2", stream.get(0));
        assertEquals("2. book3", stream.get(1));
        assertEquals(globals.PLEASE_ENTER_ID_OF_BOOK, stream.get(2));
        assertEquals(globals.THANK_YOU_FOR_RETURNING_THE_BOOK,stream.get(3));
    }

    @Test
    public void WhenOptionTwoOnBookMenuShouldShowMenu() {
        menu.executeOption("0");
        menu.executeOption("2");

        List<String> stream = out.getOutput();
        mainMenuAppeared(stream, 5);
    }

    @Test
    public void WhenOptionTwoOnMovieMenuShouldShowMMenu() {
        menu.executeOption("1");
        menu.executeOption("2");

        List<String> stream = out.getOutput();
        mainMenuAppeared(stream, 5);
    }

    @Test
    public void movieMenuAfterCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("1");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        movieMenuAppeared(stream, 2);
    }

    @Test
    public void movieMenuAfterReturn() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("1");
        menu.executeOption("0");

        List<String> stream = out.getOutput();
        movieMenuAppeared(stream, 4);
    }
    @Test
    public void bookMenuAfterCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("0");
        menu.executeOption("1");

        List<String> stream = out.getOutput();
        bookMenuAppeared(stream, 2);
    }

    @Test
    public void bookMenuAfterReturn() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        menu.setCurrentOption("0");
        menu.executeOption("0");

        List<String> stream = out.getOutput();
        bookMenuAppeared(stream, 4);
    }

    private void bookMenuAppeared(List<String> stream, int init) {
        assertEquals(globals.BOOK_HEADER, stream.get(init));
        assertEquals("1:name:author:2000", stream.get(init + 1));
        assertEquals("0 ." + globals.RETURN_BOOK, stream.get(init + 2));
        assertEquals("1 ." + globals.CHECKOUT_BOOK, stream.get(init + 3));
        assertEquals("2 ." + globals.RETURN_MENU, stream.get(init + 4));
    }

    private void movieMenuAppeared(List<String> stream, int init) {
        assertEquals(globals.MOVIE_HEADER, stream.get(init));
        assertEquals("1:name:2000:director:3", stream.get(init + 1));
        assertEquals("0 ." + globals.RETURN_MOVIE, stream.get(init + 2));
        assertEquals("1 ." + globals.CHECKOUT_MOVIE, stream.get(init + 3));
        assertEquals("2 ." + globals.RETURN_MENU, stream.get(init + 4));
    }

    private void mainMenuAppeared(List<String> stream, int init) {
        assertEquals("0. " + globals.SHOW_BOOK_MENU, stream.get(init));
        assertEquals("1. " + globals.SHOW_MOVIE_MENU, stream.get(init + 1));
        assertEquals("2. " + globals.SHOW_USER_DETAILS, stream.get(init + 2));
        assertEquals("3. " + globals.EXIT_APP, stream.get(init + 3));
    }
}
