package com.twu.biblioteca.core;

import java.util.List;

public interface BookService {
    List<String[]> getBooks();

    String checkout(int id);

    String returnBook(int id);
}
