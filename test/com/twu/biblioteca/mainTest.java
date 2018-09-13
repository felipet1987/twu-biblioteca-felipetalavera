package com.twu.biblioteca;

import com.twu.biblioteca.app.AppMenu;
import com.twu.biblioteca.app.ListMenu;
import com.twu.biblioteca.app.MainController;
import com.twu.biblioteca.mocks.TestInput;
import com.twu.biblioteca.mocks.TestOutput;
import com.twu.biblioteca.repository.MemoryBookRepository;
import com.twu.biblioteca.repository.MemoryMovieRepository;
import com.twu.biblioteca.repository.MemoryUserRepository;
import com.twu.biblioteca.service.ListBookService;
import com.twu.biblioteca.service.ListMovieService;
import com.twu.biblioteca.service.ListUserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class mainTest {


    private MainController mainController;
    private InputPort in;
    private OutputPort out;
    private UserRepository userRepo;
    private UserService userService;
    private BookRepository bookRepo;
    private BookService bookService;
    private MovieRepository movieRepo;
    private MovieService movieService;
    private AppMenu menu;


    @Before
    public void setUp() {
        in = new TestInput();
        out = new TestOutput();
        userRepo = new MemoryUserRepository();
        userService = new ListUserService(userRepo);
        bookRepo = new MemoryBookRepository();
        bookService = new ListBookService(bookRepo);
        movieRepo = new MemoryMovieRepository();
        movieService = new ListMovieService(movieRepo);
        menu = new ListMenu(in, out, userService, bookService, movieService);
        mainController = new MainController(menu);
    }

    @Test
    public void whenLginCorrectAndChooseOneShowMenu() {


        List<String> data = new ArrayList<>();
        data.add("123-4567");
        data.add("password");
        data.add("0");
        in.setInput(data);


        mainController.start();


        List<String> stream = out.getOutput();


        assertEquals(true, menu.isLogged());
        assertEquals("enter library number", stream.get(0));
        assertEquals("enter password", stream.get(1));

        assertEquals("Welcome", stream.get(2));
        assertEquals("0. show book menu", stream.get(3));
        assertEquals("1. show movie menu", stream.get(4));
        assertEquals("2. show user details", stream.get(5));
        assertEquals("3. exit app", stream.get(6));

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

        assertEquals("enter library number", stream.get(0));
        assertEquals("enter password", stream.get(1));
        assertEquals("enter library number", stream.get(2));
        assertEquals("enter password", stream.get(3));
        assertEquals("Welcome", stream.get(4));


    }

    @Test
    public void whenUseChooseZeroShowBooks() {
        List<String> data = new ArrayList<>();
        data.add("0");
        in.setInput(data);

        mainController.nextOption();


        List<String> stream = out.getOutput();
        assertEquals("please enter an option", stream.get(0));
        assertEquals("ID:NAME:AUTHOR:YEAR", stream.get(1));

    }
    @Test
    public void whenUseChooseOneShowMovies() {
        List<String> data = new ArrayList<>();
        data.add("1");
        in.setInput(data);

        mainController.nextOption();

        List<String> stream = out.getOutput();
        assertEquals("please enter an option", stream.get(0));
        assertEquals("ID:NAME:YEAR:DIRECTOR:RATING", stream.get(1));

    }

    @Test
    public void showUserDetails() {
        List<String> data = new ArrayList<>();
        data.add("123-4567");
        data.add("password");
        data.add("2");
        in.setInput(data);


        mainController.start();
        mainController.nextOption();

        List<String> stream = out.getOutput();
        assertEquals("Felipe", stream.get(8));
        assertEquals("correo@mail.cl", stream.get(9));
        assertEquals("+56-991234567", stream.get(10));


    }

    @Test
    public void succesfulBookCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        data.add("1");
        data.add("Book 1");
        in.setInput(data);



        mainController.nextOption();
        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_NAME_OF_BOOK, stream.get(6));
        assertEquals(globals.THANK_YOU_ENJOY_THE_BOOK, stream.get(7));

    }
    @Test
    public void unSuccesfulBookCheckout() {
        List<String> data = new ArrayList<>();
        data.add("0");
        data.add("1");
        data.add("Book 2");
        in.setInput(data);

        mainController.nextOption();
        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_NAME_OF_BOOK, stream.get(6));
        assertEquals(globals.THAT_BOOK_IS_NOT_AVAILABLE, stream.get(7));

    }

    @Test
    public void succesfulMovieCheckout() {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("1");
        data.add("movie 1");
        in.setInput(data);

        mainController.nextOption();
        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_NAME_OF_MOVIE, stream.get(7));
        assertEquals(globals.THANK_YOU_ENJOY_THE_MOVIE, stream.get(8));

    }
    @Test
    public void succesfulMovieReturn() {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("0");
        data.add("movie 2");
        in.setInput(data);

        mainController.nextOption();
        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_NAME_OF_MOVIE, stream.get(7));
        assertEquals(globals.THANK_YOU_FOR_RETURNING_THE_MOVIE, stream.get(8));

    }
    @Test
    public void unSuccesfulMovieReturn() {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("0");
        data.add("movie");
        in.setInput(data);




        mainController.nextOption();
        mainController.nextOption();


        List<String> stream = out.getOutput();

        assertEquals(globals.PLEASE_ENTER_NAME_OF_MOVIE, stream.get(7));
        assertEquals(globals.THAT_IS_NOT_A_VALID_MOVIE_TO_RETURN, stream.get(8));

    }






}
