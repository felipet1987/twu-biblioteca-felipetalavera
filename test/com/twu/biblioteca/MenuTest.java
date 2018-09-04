package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void getBooksCmd() {

        BookRepository repo = new DummyRepository();
        GetBooksCmd getBooks = new GetBooksCmd(repo);

        String[][] bookListView = getBooks.execute();


        String[][] expected = {{"0","Name1","Author1","2018"}};

        assertEquals(expected[0][0],bookListView[0][0]);
        assertEquals(expected[0][1],bookListView[0][1]);
        assertEquals(expected[0][2],bookListView[0][2]);
        assertEquals(expected[0][3],bookListView[0][3]);



    }

    @Test
    public void ShowMessageCmd() {
        WelcomeCmd welcome = new WelcomeCmd();
        String message = welcome.execute();
        assertEquals("Welcome",message);

    }


    @Test
    public void showMenu() {
        getMenuCmd getMenu = new getMenuCmd();
        String[]  menuView = getMenu.execute();

        assertEquals("List Books",menuView[0]);

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
