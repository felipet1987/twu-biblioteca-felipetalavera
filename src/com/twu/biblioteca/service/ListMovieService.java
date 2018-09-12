package com.twu.biblioteca.service;

import com.twu.biblioteca.MovieRepository;
import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.globals;
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
            return globals.THANK_YOU_FOR_RETURNING_THE_MOVIE;
        } catch (Exception e) {
            return globals.THAT_IS_NOT_A_VALID_MOVIE_TO_RETURN;
        }
    }

    @Override
    public String checkout(int id){
        try{
            repo.checkout(id);
            return globals.THANK_YOU_ENJOY_THE_MOVIE;
        }catch (Exception e){
            return globals.THAT_MOVIE_IS_NOT_AVAILABLE;
        }

    }

    @Override
    public int findByName(String name) {
        return repo.findIdByName(name);
    }
}
