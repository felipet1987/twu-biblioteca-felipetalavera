package com.twu.biblioteca;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {


    @Test
    public void test() {
        assertEquals(1, 1);
    }


    @Test
    public void WelcomeMessage() {
        Librarian l = new Librarian();

        String message = l.sendWelcome();

        assertEquals(Constants.WELCOME_TO_BIBLIOTECA, message);

    }

    @Test
    public void showAllBooks() {

        List<Book> bookList = getBookList();

        Librarian l = new Librarian();
        l.addBookList(bookList);

        assertEquals(getExampleBookList(),l.bookListToString());
    }







    private List<Book> getBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("libro1", "Author 1",2018));
        bookList.add(new Book("libro2", "Author 2", 2018));
        return bookList;
    }

    private String getExampleBookList() {
        return "1,libro1\n" + "2,libro2\n";
    }
}
