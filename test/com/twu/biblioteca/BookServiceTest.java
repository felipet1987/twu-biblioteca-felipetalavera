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

}
