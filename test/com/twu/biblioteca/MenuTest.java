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
        List<String[]> bookListView = menu.getBooks();


        String[] expected = {"0","Name1","Author1","2018"};

        String[] book = bookListView.get(0);

        assertEquals(expected[0],book[0]);
        assertEquals(expected[1],book[1]);
        assertEquals(expected[2],book[2]);
        assertEquals(expected[3],book[3]);

        assertEquals(1,bookListView.size());



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
    public void invalidMenuOption() {


        BookRepository repo = new DummyRepository();
        BookMenu menu = new BookMenu(repo);


        assertEquals(true,menu.isValid("List Books"));
        assertEquals(false,menu.isValid("List "));

    }

    @Test
    public void checkout() {

    }

    private class DummyRepository implements BookRepository {
        @Override
        public List<Book> getBookList() {


            List<Book> booklist = new ArrayList<Book>();

            booklist.add(new Book("Name1","Author1",2018,false));
            booklist.add(new Book("Name2","Author2",2018,true));


            return booklist;
        }
    }
}
