package com.twu.biblioteca;

import com.twu.biblioteca.app.AppMenu;
import com.twu.biblioteca.app.ListMenu;
import com.twu.biblioteca.app.MainController;
import com.twu.biblioteca.repository.MemoryBookRepository;
import com.twu.biblioteca.repository.MemoryMovieRepository;
import com.twu.biblioteca.repository.MemoryUserRepository;
import com.twu.biblioteca.service.ListBookService;
import com.twu.biblioteca.service.ListMovieService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class mainTest {


    private  MainController mainController;
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
    public void setUp()  {
         in = new TestInput();
         out = new TestOutput();
         userRepo = new MemoryUserRepository();
         userService = new ListUserService(userRepo);
         bookRepo = new MemoryBookRepository();
         bookService = new ListBookService(bookRepo);
         movieRepo = new MemoryMovieRepository();
         movieService = new ListMovieService(movieRepo);
         menu = new ListMenu(in,out,userService,bookService,movieService);
         mainController =  new MainController(menu);

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


        assertEquals(true,menu.isLogged());
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
}
