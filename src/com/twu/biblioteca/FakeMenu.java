package com.twu.biblioteca;

public class FakeMenu implements com.twu.biblioteca.app.AppMenu {
    private final InputPort in;
    private final OutputPort out;

    public FakeMenu(InputPort in, OutputPort out) {
        this.in = in;
        this.out = out;

    }

    @Override
    public void showWelcome() {
        out.print(globals.WELCOME);
    }

    @Override
    public boolean login() {
        out.print(globals.ENTER_LIBRARY_NUMBER);
        //String number = input.getInput();
        out.print(globals.ENTER_PASSWORD);
        //String password = input.getInput();

        if (in.getInput() == "123-456") {
            return false;
        }
        return true;

    }

    @Override
    public void showBookMenu() {

    }

    @Override
    public String waitForUser() {
        out.print(globals.PLEASE_ENTER_AN_OPTION);
        String option = in.getInput();
        return option;
    }

    @Override
    public void executeOption(String option) {
        if (option == "0") {
            out.print(globals.BOOK_HEADER);
        }

    }

    @Override
    public void showMenu() {

    }

    @Override
    public void showMovieMenu() {

    }


    @Override
    public void setCurrentOption(String i) {

    }

    @Override
    public void executeBookCheckout(String name) {

    }

    @Override
    public String waitForBookName() {
        return null;
    }

    @Override
    public String waitForMovieName() {
        return null;
    }

    @Override
    public void showUserDetails() {

    }

    @Override
    public boolean isExited() {
        return false;
    }

    @Override
    public void newPage() {

    }
}
