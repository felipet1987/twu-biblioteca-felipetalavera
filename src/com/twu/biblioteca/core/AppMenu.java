package com.twu.biblioteca.core;

import java.util.List;

public interface AppMenu {
    String start();

    List<String[]> getBooks();

    String[] getMenu();

    boolean isValid(String option);

    void returnBook(int id) throws Exception;

    void checkOutBook(int id) throws Exception;
}
