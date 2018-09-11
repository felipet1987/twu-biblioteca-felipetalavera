package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
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
//
//    @Test
//    public void SuccessfulReturn() {
//
//
//        ((TestInput) input).setInput(0);
//        controller.returnBook();
//        List<String> out = ((TestOutput) output).getOutput();
//        assertEquals("Thank you for returning the book.", out.get(0));
//
//
//    }
//
//    @Test
//    public void UnSuccessfulReturn() {
//
//
//        ((TestInput) input).setInput(1);
//        controller.returnBook();
//        List<String> out = ((TestOutput) output).getOutput();
//        assertEquals("That is not a valid book to return.", out.get(0));
//
//
//    }








}
