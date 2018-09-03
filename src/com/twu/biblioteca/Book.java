package com.twu.biblioteca;

public class Book {
    private final String name;
    private final int year;
    private String author;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }
    public int getYear(){
        return this.year;
    }

    @Override
    public String toString() {
        return name + ":" + author + ":" + year;
    }
}
