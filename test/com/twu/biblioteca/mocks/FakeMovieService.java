package com.twu.biblioteca.mocks;

import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.globals;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieService implements MovieService {
    @Override
    public List<String[]> getMovies() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"1", "name", "2000", "director", "3"});
        return list;
    }

    @Override
    public String returnMovie(int id) {
        return globals.THANK_YOU_FOR_RETURNING_THE_MOVIE;
    }

    @Override
    public String checkout(int id) {
        if (id == 0) {
            return globals.THAT_MOVIE_IS_NOT_AVAILABLE;
        }
        return globals.THANK_YOU_ENJOY_THE_MOVIE;
    }

    @Override
    public int findByName(String name) {
        if (name == "nam") {
            return 0;
        }
        return 1;
    }

    @Override
    public List<String> showCheckedMovies() {

        List<String> list = new ArrayList<>();
        list.add("1. movie2");
        list.add("2. movie3");
        return list;
    }

}
