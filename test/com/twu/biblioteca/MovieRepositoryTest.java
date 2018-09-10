package com.twu.biblioteca;

import com.twu.biblioteca.core.MovieRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryTest {
    @Test
    public void shouldReturnListOfMovies() {
        MovieRepository repo = new MemoryMovieRepository();

        List<Movie> list = repo.getMovies();
        Movie expected = new Movie("movie 1",2018,"Director 1",2);

        assertEquals(expected.getName(),list.get(0).getName());
        assertEquals(expected.getYear(),list.get(0).getYear());
        assertEquals(expected.getDirector(),list.get(0).getDirector());
        assertEquals(expected.getRating(),list.get(0).getRating());


    }
}
