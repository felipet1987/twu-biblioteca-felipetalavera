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

    @Override
    public String returnMovie(int id) {
        try {
            repo.returnMovie(id);
            return "That is not a valid movie to return.";
        } catch (Exception e) {
            return "Thank you for returning the movie.";
        }
    }

    @Override
    public String checkout(int id){
        try{
            repo.checkout(id);
            return "Thank you! Enjoy the movie";
        }catch (Exception e){
            return "That movie is not available.";
        }

    }
}
