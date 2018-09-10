package com.twu.biblioteca.core;

import com.twu.biblioteca.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies();

    void checkout(int i);

    Movie findBy(int i);

    void returnMovie(int i);
}
