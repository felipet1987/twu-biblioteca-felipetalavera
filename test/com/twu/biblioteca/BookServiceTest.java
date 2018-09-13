package com.twu.biblioteca;

import com.twu.biblioteca.mocks.FakeBookRepository;
import com.twu.biblioteca.service.ListBookService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {
    @Test
    public void ShouldGetBookListView() {
        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        List<String[]> bookListView = service.getBooks();

        String[] expected = {"1", "name", "author", "1"};


        String[] book = bookListView.get(0);

        assertEquals(expected[0], book[0]);
        assertEquals(expected[1], book[1]);
        assertEquals(expected[2], book[2]);
        assertEquals(expected[3], book[3]);

        assertEquals(1, bookListView.size());

    }

    @Test
    public void SuccessfulCheckout() {

        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        assertEquals("Thank you! Enjoy the book",service.checkout(0));

    }

    @Test
    public void UnSuccessfulCheckout() {

        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);
        assertEquals("That book is not available.", service.checkout(1));

    }

    @Test
    public void SuccessfulReturn() {

        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);
        assertEquals("Thank you for returning the book.",service.returnBook(0));


    }

    @Test
    public void UnSuccessfulReturn() {

        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);
        assertEquals("That is not a valid book to return.",service.returnBook(1));


    }








}
