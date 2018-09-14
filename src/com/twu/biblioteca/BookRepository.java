package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getReturnedBooks();

    void returnBook(int id) throws Exception;

    void checkOutBook(int id) throws Exception;

    boolean isCheckedOut(int id);

    Book findBy(int id);

    int findIdByName(String name);

    List<Book> getCheckedBooks();

}
