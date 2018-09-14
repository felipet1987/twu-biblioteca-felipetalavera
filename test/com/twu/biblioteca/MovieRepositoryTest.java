package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MemoryMovieRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryTest {
    @Test
    public void shouldReturnListOfMovies() {
        MovieRepository repo = new MemoryMovieRepository();

        List<Movie> list = repo.getReturnedMovies();
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
        assertEquals(m.getName(), "movie 1");
    }

    @Test
    public void shouldCheckOutMovie() throws Exception {
        MovieRepository repo = new MemoryMovieRepository();

        repo.checkout(1);
        assertEquals(repo.findBy(1).isCheckedOut(), true);

    }

    @Test
    public void shouldReturnMovie() throws Exception {
        MovieRepository repo = new MemoryMovieRepository();
        repo.returnMovie(2);
        assertEquals(repo.findBy(2).isCheckedOut(), false);

    }

    @Test(expected = Exception.class)
    public void failReturn() throws Exception {
        MovieRepository repo = new MemoryMovieRepository();
        repo.returnMovie(1);

    }

    @Test(expected = Exception.class)
    public void failCheckout() throws Exception {
        MovieRepository repo = new MemoryMovieRepository();

        repo.checkout(2);

    }

    @Test
    public void findByIncorrectNameShoudlReturnMinusOne() {
        MovieRepository repo = new MemoryMovieRepository();
        assertEquals(-1, repo.findIdByName("noname"));

    }

    @Test
    public void name() throws Exception {
        MovieRepository repo = new MemoryMovieRepository();
        assertEquals(1, repo.getCheckedMovies().size());
        repo.checkout(1);
        assertEquals(2, repo.getCheckedMovies().size());

    }
}
