package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBookList();

    void returnBook(int id);

    void checkOutBook(int id);

    boolean isCheckedOut(int id);
}
