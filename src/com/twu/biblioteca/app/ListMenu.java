package com.twu.biblioteca.app;

import com.twu.biblioteca.*;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;


public class ListMenu implements AppMenu {

    private final InputPort input;
    private final OutputPort output;
    private final UserService userService;
    private final BookService bookService;
    private final MovieService movieService;
    private List<String[]> options;
    private String actualOption;
    private boolean exitStatus;

    public ListMenu(InputPort in, OutputPort out, UserService userService, BookService bookService, MovieService movieService) {
        this.input = in;
        this.output = out;
        options = setMenuOptions();
        this.userService = userService;
        this.bookService = bookService;
        this.movieService = movieService;
        this.exitStatus = false;
    }

    private List<String[]> setMenuOptions() {
        options = new ArrayList<>();
        options.add(new String[]{"0", globals.SHOW_BOOK_MENU});
        options.add(new String[]{"1", globals.SHOW_MOVIE_MENU});
        options.add(new String[]{"2", globals.SHOW_USER_DETAILS});
        options.add(new String[]{"3", globals.EXIT_APP});
        return options;
    }

    @Override
    public void showWelcome() {
        output.print(globals.WELCOME);
    }

    @Override
    public boolean login() {
        boolean login = getLogin();
        if (login) {
            return true;
        } else {
            return false;
        }
    }

    private boolean getLogin() {
        output.print(globals.ENTER_LIBRARY_NUMBER);
        String number = input.getInput();
        output.print(globals.ENTER_PASSWORD);
        String password = input.getInput();
        return userService.login(number, password);
    }

    @Override
    public void showBookMenu() {
        output.print(globals.BOOK_HEADER);
        List<String[]> books = bookService.getBooks();
        for (String[] b : books) {
            String book = b[0] + ":" + b[1] + ":" + b[2] + ":" + b[3];
            output.print(book);
        }
        showBookOptions();
        setCurrentOption("0");
    }

    @Override
    public String waitForUser() {
        output.print(globals.PLEASE_ENTER_AN_OPTION);
        String option = input.getInput();
        return option;
    }

    @Override
    public void executeOption(String option) {
        if (this.actualOption == "0") {
            executeBookOption(option);
            return;
        }
        if (this.actualOption == "1") {
            executeMovieOption(option);
            return;
        }
        if (Integer.parseInt(option) == 0) {
            showBookMenu();
            return;
        }
        if (Integer.parseInt(option) == 1) {
            showMovieMenu();
            return;
        }
        if (Integer.parseInt(option) == 2) {
            showUserDetails();
            return;
        }
        if (Integer.parseInt(option) == 3) {
            exit();
            return;
        }
        output.print(globals.INVALID_OPTION);
        return;
    }

    private void executeMovieOption(String option) {
        if (Integer.parseInt(option) == 1) {
            executeMovieCheckout(waitForMovieName());
            showMovieMenu();
            return;
        }
        if (Integer.parseInt(option) == 0) {
            showCheckoutMovies();
            executeMovieReturn(waitForMovieName());
            showMovieMenu();
            return;
        }
        if (Integer.parseInt(option) == 2) {
            setCurrentOption("");
            showMenu();
            return;
        }
        return;
    }

    private void executeBookOption(String option) {
        if (Integer.parseInt(option) == 1) {
            executeBookCheckout(waitForBookName());
            showBookMenu();
            return;
        }
        if (Integer.parseInt(option) == 0) {
            showCheckoutBooks();
            executeBookReturn(waitForBookName());
            showBookMenu();
            return;
        }
        if (Integer.parseInt(option) == 2) {
            setCurrentOption("");
            showMenu();
            return;
        }

    }

    private void showCheckoutBooks() {
        List<String> checkedBooks = bookService.showCheckoutBooks();
        for (String b : checkedBooks) {
            output.print(b);
        }
    }

    private void showCheckoutMovies() {
        List<String> checkedMovies = movieService.showCheckedMovies();
        for (String m : checkedMovies) {
            output.print(m);
        }
    }

    private void exit() {
        this.exitStatus = true;
        output.print(globals.EXIT_APP_MESSAGE);
        output.exit();
    }

    private void executeBookReturn(String id) {
        output.print(bookService.returnBook(Integer.parseInt(id)));
    }

    private void executeMovieReturn(String id) {
        output.print(movieService.returnMovie(Integer.parseInt(id)));
    }

    private void executeMovieCheckout(String id) {
        output.print(movieService.checkout(Integer.parseInt(id)));
    }

    @Override
    public void executeBookCheckout(String id) {
        output.print(bookService.checkout(Integer.parseInt(id)));
    }

    @Override
    public void showMenu() {
        for (String[] o : options) {
            output.print(o[0] + ". " + o[1]);
        }
    }

    @Override
    public void showMovieMenu() {
        output.print(globals.MOVIE_HEADER);
        List<String[]> movies = movieService.getMovies();
        for (String[] movie : movies) {
            output.print(movie[0] + ":" + movie[1] + ":" + movie[2] + ":" + movie[3] + ":" + movie[4]);
        }
        showMovieOptions();
        setCurrentOption("1");
    }

    @Override
    public void setCurrentOption(String o) {
        this.actualOption = o;
    }

    @Override
    public String waitForBookName() {
        output.print(globals.PLEASE_ENTER_ID_OF_BOOK);
        String option = input.getInput();
        return option;
    }

    @Override
    public String waitForMovieName() {
        output.print(globals.ENTER_ID_OF_MOVIE);
        String option = input.getInput();
        return option;
    }

    @Override
    public void showUserDetails() {
        User u = userService.getLoggedUser();
        output.print(u.getName());
        output.print(u.getEmail());
        output.print(u.getPhone());
        output.print(globals.BACK_TO_MENU);
        input.getInput();
        output.newPage();
        showMenu();
    }

    @Override
    public boolean isExited() {
        return this.exitStatus;
    }

    @Override
    public void newPage() {
        output.newPage();
    }

    private void showMovieOptions() {
        output.print("0 ." + globals.RETURN_MOVIE);
        output.print("1 ." + globals.CHECKOUT_MOVIE);
        output.print("2 ." + globals.RETURN_MENU);
    }

    private void showBookOptions() {
        output.print("0 ." + globals.RETURN_BOOK);
        output.print("1 ." + globals.CHECKOUT_BOOK);
        output.print("2 ." + globals.RETURN_MENU);
    }
}
