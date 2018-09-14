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

        assertEquals(globals.THANK_YOU_ENJOY_THE_BOOK,service.checkout(0));
    }

    @Test
    public void UnSuccessfulCheckout() {
        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        assertEquals(globals.THAT_BOOK_IS_NOT_AVAILABLE, service.checkout(1));
    }

    @Test
    public void SuccessfulReturn() {
        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        assertEquals(globals.THANK_YOU_FOR_RETURNING_THE_BOOK, service.returnBook(0));
    }

    @Test
    public void UnSuccessfulReturn() {
        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        assertEquals(globals.THAT_IS_NOT_A_VALID_BOOK_TO_RETURN, service.returnBook(1));
    }

    @Test
    public void getCheckoutBooks() {
        BookRepository repo = new FakeBookRepository();
        BookService service = new ListBookService(repo);

        List<String> list = service.showCheckoutBooks();
        assertEquals("1. book 1",list.get(0));
    }
}
