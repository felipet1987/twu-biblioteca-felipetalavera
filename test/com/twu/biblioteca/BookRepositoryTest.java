package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.MemoryBookRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {
    @Test
    public void shouldGetBooks() {
        BookRepository repo = new MemoryBookRepository();

        List<Book> list = repo.getReturnedBooks();
        Book expected = new Book(1, "Book 1", "Author 1", 2000, false);
        assertEquals(expected.getId(), list.get(0).getId());
        assertEquals(expected.getName(), list.get(0).getName());
        assertEquals(2,list.size());

    }

    @Test
    public void shouldReturnBook() throws Exception {
        BookRepository repo = new MemoryBookRepository();
        repo.returnBook(2);


        assertEquals(false, repo.findBy(2).isCheckedOut());

    }

    @Test
    public void shouldCheckout() throws Exception {
        BookRepository repo = new MemoryBookRepository();
        repo.checkOutBook(1);

        assertEquals(true, repo.findBy(1).isCheckedOut());

    }

    @Test(expected = Exception.class)
    public void failCheckout() throws Exception {

        BookRepository repo = new MemoryBookRepository();
        int id = 2;
        repo.checkOutBook(id);


    }

    @Test(expected = Exception.class)
    public void failReturn() throws Exception {


        BookRepository repo = new MemoryBookRepository();
        int id = 1;
        repo.returnBook(id);

    }

    @Test
    public void findByName() {
        BookRepository repo = new MemoryBookRepository();
        assertEquals(2,repo.findIdByName("Book 2"));
    }

}
