package com.twu.biblioteca;

import com.twu.biblioteca.core.MovieRepository;
import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryTest {
    @Test
    public void shouldReturnListOfMovies() {
        MovieRepository repo = new MemoryMovieRepository();

        List<Movie> list = repo.getMovies();
        Movie expected = new Movie(1, "movie 1", 2018, "Director 1", 2, false);



        assertEquals(expected.getId(), list.get(0).getId());
        assertEquals(expected.getName(), list.get(0).getName());
        assertEquals(expected.getYear(), list.get(0).getYear());
        assertEquals(expected.getDirector(), list.get(0).getDirector());
        assertEquals(expected.getRating(), list.get(0).getRating());
        assertEquals(expected.isCheckedOut(), list.get(0).isCheckedOut());


    }

    @Test
    public void shouldfindOne() {
        MovieRepository repo = new MemoryMovieRepository();
        Movie m = repo.findBy(1);
        assertEquals(m.getName(),"movie 1");
    }

    @Test
    public void shouldCheckOutMovie() {
        MovieRepository repo = new MemoryMovieRepository();

        repo.checkout(1);
        assertEquals(repo.findBy(1).isCheckedOut(), true);

    }

    @Test
    public void shouldReturnMovie() {
        MovieRepository repo = new MemoryMovieRepository();
        repo.returnMovie(2);
        assertEquals(repo.findBy(2).isCheckedOut(), false);

    }
}
