package com.twu.biblioteca;

import com.twu.biblioteca.mocks.FakeMovieRepository;
import com.twu.biblioteca.service.ListMovieService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {
    @Test
    public void ShouldGetMovieListView() {
        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);

        List<String[]> movieListView = service.getMovies();


        String[] expected = {"1", "name", "2000", "director","3"};


        String[] movie = movieListView.get(0);

        assertEquals(expected[0], movie[0]);
        assertEquals(expected[1], movie[1]);
        assertEquals(expected[2], movie[2]);
        assertEquals(expected[3], movie[3]);
        assertEquals(expected[4], movie[4]);

        assertEquals(1, movieListView.size());

    }


    @Test
    public void SuccessfulCheckout() throws Exception {

        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);

        assertEquals("Thank you! Enjoy the movie",service.checkout(1));

    }

    @Test
    public void UnSuccessfulCheckout() throws Exception {

        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);
        assertEquals("That movie is not available.", service.checkout(0));

    }
    @Test
    public void successfulReturn() {

        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);
        assertEquals("Thank you for returning the movie.",service.returnMovie(1));


    }

    @Test
    public void UnSuccesfulReturn() {
        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);
        assertEquals("That is not a valid movie to return.",service.returnMovie(0));

    }

    @Test
    public void returnCheckedBooks() {
        MovieRepository repo = new FakeMovieRepository();
        MovieService service = new ListMovieService(repo);
        List<String> list = service.showCheckedMovies();
        assertEquals("1. movie 1",list.get(0));
    }
}
