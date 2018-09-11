package com.twu.biblioteca;

import java.util.List;

public interface BookService {
    List<String[]> getBooks();

    String checkout(int id);
}
