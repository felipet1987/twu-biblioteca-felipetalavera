package com.twu.biblioteca;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

public class Book {
    private final String name;
    private final String author;
    private final int year;
    private final boolean checkedOut;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Book(String name, String author, int year, boolean checkedOut) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
}
