package com.twu.biblioteca.core;

import com.twu.biblioteca.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBookList();

    void returnBook(int id) throws Exception;

    void checkOutBook(int id) throws Exception;

    boolean isCheckedOut(int id);

    Book findBy(int id);

}
