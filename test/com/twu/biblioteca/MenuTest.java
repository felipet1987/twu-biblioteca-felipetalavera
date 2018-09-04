package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void getBooks() {

        BookRepository repo = new TestRepository();
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

        BookRepository repo = new TestRepository();
        BookMenu menu = new BookMenu(repo);
        String message = menu.start();
        assertEquals("Welcome",message);

    }


    @Test
    public void getMenu() {


        BookRepository repo = new TestRepository();
        BookMenu menu = new BookMenu(repo);




        String[]  menuView = menu.getMenu();


        assertEquals("List Books",menuView[0]);

    }

    @Test
    public void invalidMenuOption() {


        BookRepository repo = new TestRepository();
        BookMenu menu = new BookMenu(repo);


        assertEquals(true,menu.isValid("List Books"));
        assertEquals(false,menu.isValid("List "));

    }

    @Test
    public void returnBook () {
        BookRepository repo = new TestRepository();
        BookMenu menu = new BookMenu(repo);

        List<String[]> list = menu.getBooks();
        assertEquals(1,list.size());

        int id = 1;
        menu.returnBook(id);

        list = menu.getBooks();
        assertEquals(2,list.size());

    }

    @Test
    public void checkoutBook() {
        BookRepository repo = new Test2Repository();
        BookMenu menu = new BookMenu(repo);

        List<String[]> list = menu.getBooks();
        assertEquals(2,list.size());

        int id = 1;
        menu.checkOutBook(id);
        list = menu.getBooks();
        assertEquals(1,list.size());

    }

    private class TestRepository implements BookRepository {
        private ArrayList<Book> booklist;

        public TestRepository() {

            booklist = new ArrayList<Book>();

            booklist.add(new Book(1, "Name1","Author1",2018,false));
            booklist.add(new Book(2, "Name2","Author2",2018,true));



        }




        @Override
        public List<Book> getBookList() {

            return booklist;
        }

        @Override
        public void returnBook(int id) {
            booklist.get(id).returnBook();
;        }

        @Override
        public void checkOutBook(int id) {

        }
    }

    private class Test2Repository implements BookRepository {

        private final ArrayList<Book> booklist;

        public Test2Repository() {

            booklist = new ArrayList<Book>();

            booklist.add(new Book(1,"Name1","Author1",2018,false));
            booklist.add(new Book(2,"Name2","Author2",2018,false));



        }

        @Override
        public List<Book> getBookList() {
            return booklist;
        }

        @Override
        public void returnBook(int id) {

        }

        @Override
        public void checkOutBook(int id) {
            booklist.get(id).checkOutBook();
        }
    }
}
