package com.twu.biblioteca.core;

import com.twu.biblioteca.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies();

    void checkout(int i);


    Movie findBy(int i);
}
