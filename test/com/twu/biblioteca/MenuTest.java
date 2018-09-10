package com.twu.biblioteca;

import com.twu.biblioteca.core.AppMenu;
import com.twu.biblioteca.core.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    public static final String LIST_BOOKS = "List Books";
    public static final String LIST_MOVIES = "List Movies";
    BookRepository repo;
    AppMenu menu;

    @Before
    public void setUp() {
        repo = new TestRepository();
        menu = new ListMenu(repo);

    }

    @Test
    public void getBooks() {


        List<String[]> bookListView = menu.getBooks();


        String[] expected = {"1", "Name1", "Author1", "2018"};

        String[] book = bookListView.get(0);

        assertEquals(expected[0], book[0]);
        assertEquals(expected[1], book[1]);
        assertEquals(expected[2], book[2]);
        assertEquals(expected[3], book[3]);

        assertEquals(1, bookListView.size());


    }


    @Test
    public void WelcomeMessage() {

        String message = menu.start();
        assertEquals("Welcome", message);

    }


    @Test
    public void getMenu() {


        String[] menuView = menu.getMenu();


        assertEquals(LIST_BOOKS, menuView[0]);
        assertEquals(LIST_MOVIES, menuView[1]);

    }

    @Test
    public void invalidMenuOption() {


        assertEquals(true, menu.isValid("List Books"));
        assertEquals(false, menu.isValid("List "));

    }

    @Test
    public void returnBook() throws Exception {


        int id = 2;

        menu.returnBook(id);
    }

    @Test
    public void checkoutBook() throws Exception {

        BookRepository repo = new Test2Repository();
        menu = new ListMenu(repo);

        List<String[]> list = menu.getBooks();
        assertEquals(2, list.size());

        int id = 1;
        menu.checkOutBook(id);
        list = menu.getBooks();
        assertEquals(1, list.size());

    }

    @Test(expected = Exception.class)
    public void failCheckout() throws Exception {


        int id = 2;
        menu.checkOutBook(id);


    }

    @Test(expected = Exception.class)
    public void failReturn() throws Exception {


        int id = 1;
        menu.returnBook(id);

    }

}
