package com.twu.biblioteca.app;


public interface AppMenu {
    void showWelcome();


    boolean login();

    void showBookMenu();

    String waitForUser();

    void executeOption(String option);

    void showMenu();

    void showMovieMenu();


    void setCurrentOption(String i);

    void executeBookCheckout(String name);

    String waitForBookName();

    String waitForMovieName();

    void showUserDetails();

    boolean isExited();

    void newPage();

}
