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

        assertEquals(getExampleBookList(),l.showBooks());
    }


    private List<Book> getBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("libro1", "Author1",2018));
        bookList.add(new Book("libro2", "Author2", 2018));
        return bookList;
    }

    private String getExampleBookList() {
        String message = "";
        message+="Id:Name:Author:Year\n";
        message+="1:libro1:Author1:2018\n";
        message+="2:libro2:Author2:2018\n";
        return message;

    }
}
