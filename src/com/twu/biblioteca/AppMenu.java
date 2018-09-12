package com.twu.biblioteca;


public interface AppMenu {
    void showWelcome();


    void login();

    void showBookMenu();

    String waitForUser();

    void executeOption(String option);
}
