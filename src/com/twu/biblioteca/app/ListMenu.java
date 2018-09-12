package com.twu.biblioteca.app;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;


public class ListMenu implements AppMenu {


    private static final String WELCOME = "Welcome";
    private final InputPort input;
    private final OutputPort output;
    private final UserService userService;
    private final BookService bookService;
    private final MovieService movieService;
    private List<String[]> options;
    private boolean logged;


    public ListMenu(InputPort in, OutputPort out, UserService userService, BookService bookService, MovieService movieService) {
        this.input = in;
        this.output = out;
        options = setMenuOptions();
        this.userService = userService;
        this.bookService = bookService;
        this.movieService = movieService;
        this.logged = false;
    }


    private List<String[]> setMenuOptions() {
        options = new ArrayList<>();
        options.add(new String[]{"0", "show book menu"});
        options.add(new String[]{"1", "show movie menu"});
        options.add(new String[]{"2", "show user details"});
        options.add(new String[]{"3", "exit app"});
        return options;
    }


    @Override
    public void showWelcome() {
        output.print(WELCOME);
    }

    @Override
    public boolean login() {
        output.print("enter library number");
        String number = input.getInput();
        output.print("enter password");
        String password = input.getInput();
        if (userService.login(number, password)) {
            this.logged = true;
            return true;
        } else {
            this.logged = false;
            return false;
        }

    }


    @Override
    public void showBookMenu() {
        output.print("ID:NAME:AUTHOR:YEAR");
        List<String[]> books = bookService.getBooks();
        for (String[] b : books) {
            String book = b[0] + ":" + b[1] + ":" + b[2] + ":" + b[3];
            output.print(book);
        }
        showBookOptions();

    }

    @Override
    public String waitForUser() {
        output.print("please enter an option");
        String option = input.getInput();
        return option;
    }

    @Override
    public void executeOption(String option) {

        if (Integer.parseInt(option) == 0) {
            showBookMenu();
            return;
        }

        output.print("Invalid Option");
        showMenu();


    }

    @Override
    public void showMenu() {
        for (String[] o : options) {
            output.print(o[0] + ". " + o[1]);
        }

    }

    @Override
    public void showMovieMenu() {
        output.print("ID:NAME:YEAR:DIRECTOR:RATING");

        List<String[]> movies = movieService.getMovies();
        for (String[] movie : movies) {
            output.print(movie[0] + ":" + movie[1] + ":" + movie[2] + ":" + movie[3] + ":" + movie[4]);
        }
        showMovieOptions();


    }

    @Override
    public boolean isLogged() {
        return this.logged;
    }


    private void showMovieOptions() {
        output.print("0 . return movie");
        output.print("1 . checkout movie");
    }


    private void showBookOptions() {
        output.print("0 . return book");
        output.print("1 . checkout book");
    }
}
