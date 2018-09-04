package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void getBooks() {

        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);
        List<String[]> bookListView = menu.getBooks();


        String[] expected = {"1","Name1","Author1","2018"};

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
        BookMenu menu = new ListBookMenu(repo);
        String message = menu.start();
        assertEquals("Welcome",message);

    }


    @Test
    public void getMenu() {


        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);




        String[]  menuView = menu.getMenu();


        assertEquals("List Books",menuView[0]);

    }

    @Test
    public void invalidMenuOption() {


        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);


        assertEquals(true,menu.isValid("List Books"));
        assertEquals(false,menu.isValid("List "));

    }

    @Test
    public void returnBook () throws Exception {
        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);


        int id = 2;

        menu.returnBook(id);




    }

    @Test
    public void checkoutBook() throws Exception {
        BookRepository repo = new Test2Repository();
        BookMenu menu = new ListBookMenu(repo);

        List<String[]> list = menu.getBooks();
        assertEquals(2,list.size());

        int id = 1;
        menu.checkOutBook(id);
        list = menu.getBooks();
        assertEquals(1,list.size());

    }

    @Test(expected = Exception.class)
    public void failCheckout() throws Exception {
        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);

        int id = 2;
        menu.checkOutBook(id);



    }

    @Test(expected = Exception.class)
    public void failReturn() throws Exception {
        BookRepository repo = new TestRepository();
        BookMenu menu = new ListBookMenu(repo);
        int id = 1;
        menu.returnBook(id);

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

            Book book = find(id);

            book.returnBook();
;        }

        @Override
        public void checkOutBook(int id) {

        }

        @Override
        public boolean isCheckedOut(int id) {
            return find(id).isCheckedOut();
        }

        private Book find(int id) {
            for (int i = 0; i < booklist.size(); i++) {
                if(booklist.get(i).getId() == id){
                    return booklist.get(i);
                }
            }
            return new Book(-1,"","",-1,true);
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
            find(id).checkOutBook();
        }

        @Override
        public boolean isCheckedOut(int id) {

            Book book = find(id);

            return book.isCheckedOut();
        }


        private Book find(int id) {
            for (int i = 0; i < booklist.size(); i++) {
                if(booklist.get(i).getId() == id){
                    return booklist.get(i);
                }
            }
            return new Book(-1,"","",-1,true);
        }
    }
}
