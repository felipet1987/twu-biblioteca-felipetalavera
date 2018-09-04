package com.twu.biblioteca;

import java.util.List;

public interface BookMenu {
    String start();

    List<String[]> getBooks();

    String[] getMenu();

    boolean isValid(String option);

    void returnBook(int id) throws Exception;

    void checkOutBook(int id) throws Exception;
}
