package com.twu.biblioteca;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void getBooks() {

        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);
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

        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);
        String message = menu.start();
        assertEquals("Welcome", message);

    }


    @Test
    public void getMenu() {


        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);


        String[] menuView = menu.getMenu();


        assertEquals("List Books", menuView[0]);

    }

    @Test
    public void invalidMenuOption() {


        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);

        assertEquals(true, menu.isValid("List Books"));
        assertEquals(false, menu.isValid("List "));

    }

    @Test
    public void returnBook() throws Exception {
        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);

        int id = 2;

        menu.returnBook(id);
    }

    @Test
    public void checkoutBook() throws Exception {
        BookRepository repo = new Test2Repository();
        AppMenu menu = new ListMenu(repo);

        List<String[]> list = menu.getBooks();
        assertEquals(2, list.size());

        int id = 1;
        menu.checkOutBook(id);
        list = menu.getBooks();
        assertEquals(1, list.size());

    }

    @Test(expected = Exception.class)
    public void failCheckout() throws Exception {
        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);

        int id = 2;
        menu.checkOutBook(id);


    }

    @Test(expected = Exception.class)
    public void failReturn() throws Exception {
        BookRepository repo = new TestRepository();
        AppMenu menu = new ListMenu(repo);
        int id = 1;
        menu.returnBook(id);

    }

}
