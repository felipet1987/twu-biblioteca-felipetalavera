package com.twu.biblioteca;

public class Movie {
    //name, year, director and movie rating (from 1-10 or unrated).
    String name;
    int year;
    String director;
    int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
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
}
