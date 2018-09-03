package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void BookDetails() {
        //Book Details - As a customer, I'd like the list of all books to include each books Author and Year Published,
        // so that I can be confident that I have found the book I am looking for.
        //The book listing should have columns for this information.

        Book book = new Book("Libro 1","Author 1",2018);

        assertEquals("Libro 1",book.getName());
        assertEquals("Author 1",book.getAuthor());
        assertEquals(2018,book.getYear());
    }

    @Test
    public void bookToString() {
        Book book = new Book("Libro 1","Author 1",2018);

        String result = book.toString();
        assertEquals("Libro 1:Author 1:2018",result);

    }
}
