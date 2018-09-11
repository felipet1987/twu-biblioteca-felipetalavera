package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {
    @Test
    public void shouldGetBooks() {
        BookRepository repo = new MemoryBookRepository();

        List<Book> list = repo.getBookList();
        Book expected = new Book(1, "Book 1", "Author 1", 2000, false);
        assertEquals(expected.getId(), list.get(0).getId());
        assertEquals(expected.getName(), list.get(0).getName());

    }

    @Test
    public void shouldReturnBook() {
        BookRepository repo = new MemoryBookRepository();
        repo.returnBook(2);

        assertEquals(false, repo.findBy(2).isCheckedOut());

    }

    @Test
    public void shouldCheckout() {
        BookRepository repo = new MemoryBookRepository();
        repo.checkOutBook(1);

        assertEquals(true, repo.findBy(1).isCheckedOut());

    }
}
