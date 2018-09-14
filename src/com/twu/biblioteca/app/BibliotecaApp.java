package com.twu.biblioteca.app;


import com.twu.biblioteca.*;
import com.twu.biblioteca.io.ConsoleInput;
import com.twu.biblioteca.io.ConsoleOutput;
import com.twu.biblioteca.repository.MemoryBookRepository;
import com.twu.biblioteca.repository.MemoryMovieRepository;
import com.twu.biblioteca.repository.MemoryUserRepository;
import com.twu.biblioteca.service.ListBookService;
import com.twu.biblioteca.service.ListMovieService;
import com.twu.biblioteca.service.ListUserService;

public class BibliotecaApp {

    public static void main(String[] args) {

        AppMenu menu = setup();

        MainController controller = new MainController(menu);


        controller.start();
        while (!controller.isExited()) {
            controller.nextOption();
        }


    }

    private static AppMenu setup() {
        InputPort in = new ConsoleInput();
        OutputPort out = new ConsoleOutput();
        UserService userService = new ListUserService(new MemoryUserRepository());
        BookService bookService = new ListBookService(new MemoryBookRepository());
        MovieService movieService = new ListMovieService(new MemoryMovieRepository());


        return new ListMenu(in, out, userService, bookService, movieService);


    }
}
