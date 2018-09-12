package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MemoryBookRepository;
import com.twu.biblioteca.repository.MemoryMovieRepository;
import com.twu.biblioteca.service.ListBookService;
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

}
