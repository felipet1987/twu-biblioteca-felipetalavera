package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void getBooks() {

        BookRepository repo = new DummyRepository();
        BookMenu menu = new BookMenu(repo);
        String[][] bookListView = menu.getBookd();






        String[][] expected = {{"0","Name1","Author1","2018"}};

        assertEquals(expected[0][0],bookListView[0][0]);
        assertEquals(expected[0][1],bookListView[0][1]);
        assertEquals(expected[0][2],bookListView[0][2]);
        assertEquals(expected[0][3],bookListView[0][3]);



    }

    @Test
    public void WelcomeMessage() {

        BookRepository repo = new DummyRepository();
        BookMenu menu = new BookMenu(repo);
        String message = menu.start();
        assertEquals("Welcome",message);

    }


    @Test
    public void getMenu() {


        BookRepository repo = new DummyRepository();
        BookMenu menu = new BookMenu(repo);




        String[]  menuView = menu.getMenu();


        assertEquals("List Books",menuView[0]);

    }

    @Test
    public void InvalidMenuOption() {


        BookRepository repo = new DummyRepository();
        BookMenu menu = new BookMenu(repo);


        assertEquals(true,menu.isValid("List Books"));
        assertEquals(false,menu.isValid("List "));

    }

    @Test
    public void checkoutBook() {


    }

    private class DummyRepository implements BookRepository {
        @Override
        public List<Book> getBookList() {


            List<Book> booklist = new ArrayList<Book>();

            booklist.add(new Book("Name1","Author1",2018));

            return booklist;
        }
    }
}
