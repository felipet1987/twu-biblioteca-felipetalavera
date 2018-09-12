package com.twu.biblioteca.app;


public interface AppMenu {
    void showWelcome();


    boolean login();

    void showBookMenu();

    String waitForUser();

    void executeOption(String option);

    void showMenu();

    void showMovieMenu();

    boolean isLogged();
}
