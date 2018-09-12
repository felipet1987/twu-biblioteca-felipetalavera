package com.twu.biblioteca;

import java.util.List;

public interface MovieService {
    List<String[]> getMovies();

    String returnMovie(int id);

    String checkout(int id);
}
