package com.twu.biblioteca.model;

public class Movie {
    //name, year, director and movie rating (from 1-10 or unrated).
    String name;
    int year;
    String director;
    int rating;
    private int id;
    private boolean checkedOut;

    public Movie(int id, String name, int year, String director, int rating, boolean checkedOut) {

        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = checkedOut;

    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public int getId() {
        return this.id;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public void checkout() {
        this.checkedOut = true;
    }

    public void returnThis() {
        this.checkedOut = false;
    }
}
