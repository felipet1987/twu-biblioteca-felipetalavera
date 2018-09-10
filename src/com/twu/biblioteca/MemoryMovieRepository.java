package com.twu.biblioteca;

import com.twu.biblioteca.core.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepository {


    private List<Movie> movies;

    public MemoryMovieRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie("movie 1",2018,"Director 1",2));

    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }
}
