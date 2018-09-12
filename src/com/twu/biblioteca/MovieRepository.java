package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies();

    void checkout(int i) throws Exception;

    Movie findBy(int i);

    void returnMovie(int i) throws Exception;
}
