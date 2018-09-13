package com.twu.biblioteca.mocks;

import com.twu.biblioteca.MovieRepository;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieRepository implements MovieRepository {
    @Override
    public List<Movie> getMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie(1,"name",2000,"director",3,false));
        list.add(new Movie(2,"name2",2000,"director",3,true));
        list.add(new Movie(3,"name3",2000,"director",3,true));

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

    @Override
    public List<Movie> getCheckedMovies() {

        List<Movie> list = new ArrayList<>();
        list.add(new Movie(1,"movie 1",1,"",2,true));
        return list;
    }
}
