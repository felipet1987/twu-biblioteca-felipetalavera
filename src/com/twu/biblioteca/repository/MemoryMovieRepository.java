package com.twu.biblioteca.repository;

import com.twu.biblioteca.MovieRepository;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepository {


    private List<Movie> movies;

    public MemoryMovieRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "movie 1",2018,"Director 1",2,false));
        movies.add(new Movie(2, "movie 2",2018,"Director 2",2,true));

    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void checkout(int id) throws Exception {
        Movie m = findBy(id);
        if(!m.isCheckedOut()){
            m.checkout();
        }else{
            throw  new Exception();
        }

    }

    @Override
    public Movie findBy(int i) {

        for (Movie movie:movies) {
            if(movie.getId() == i){
                return movie;
            }
        }
        return new Movie(-1,"",-1,"",-2,false);
    }

    @Override
    public void returnMovie(int i) throws Exception {
        Movie m = findBy(i);
        if(m.isCheckedOut()){
            m.returnThis();
        }else{
            throw new Exception();
        }


    }

    @Override
    public int finddIdByName(String name) {
        return 0;
    }
}
