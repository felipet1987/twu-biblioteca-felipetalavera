package com.twu.biblioteca.core;

import com.twu.biblioteca.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBookList();

    void returnBook(int id);

    void checkOutBook(int id);

    boolean isCheckedOut(int id);

    Book findBy(int id);

}
