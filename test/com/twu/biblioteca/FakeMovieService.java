package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieService implements MovieService {
    @Override
    public List<String[]> getMovies() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"1","name","2000","director","3"});
        return list;
    }

    @Override
    public String returnMovie(int id) {
        return null;
    }

    @Override
    public String checkout(int id) {
        return null;
    }
}
