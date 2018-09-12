package com.twu.biblioteca.service;

import com.twu.biblioteca.MovieRepository;
import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class ListMovieService implements MovieService {
    private final MovieRepository repo;

    public ListMovieService(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<String[]> getMovies() {
        List<String[]> list = new ArrayList<>();
        List<Movie> movies = repo.getMovies();
        for (Movie m: movies) {
            list.add(new String[]{String.valueOf(m.getId()),m.getName(),String.valueOf(m.getYear()),m.getDirector(),String.valueOf(m.getRating())});
        }
        return list;
    }
}
