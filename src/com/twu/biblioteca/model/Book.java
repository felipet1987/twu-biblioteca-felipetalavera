package com.twu.biblioteca.model;

public class Book {
    private final String name;
    private final String author;
    private final int year;
    private final int id;
    private boolean checkedOut;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Book(int id, String name, String author, int year, boolean checkedOut) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
        this.id = id;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void returnBook() {
        this.checkedOut = false;
    }

    public void checkOutBook() {
        this.checkedOut = true;
    }

    public int getId() {
        return this.id;
    }
}
