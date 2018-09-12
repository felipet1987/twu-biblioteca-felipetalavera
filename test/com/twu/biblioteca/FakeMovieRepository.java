package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieRepository implements MovieRepository {
    @Override
    public List<Movie> getMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie(1,"name",2000,"director",3,false));
        return list;
    }

    @Override
    public void checkout(int id) throws Exception {
        if(id == 0){
            throw new Exception();
        }
    }

    @Override
    public Movie findBy(int i) {
        return null;
    }

    @Override
    public void returnMovie(int id) throws Exception{
        if(id == 0){
            throw new Exception();
        }
    }

    @Override
    public int findIdByName(String name) {
        return 0;
    }
}
