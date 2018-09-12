package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class ListMenu implements AppMenu {


    private static final String WELCOME = "Welcome";
    private final InputPort input;
    private final OutputPort output;
    private final UserService userService;
    private final BookService bookService;
    private List<String> options;


    public ListMenu(InputPort in, OutputPort out, UserService userService, BookService bookService) {
        this.input = in;
        this.output = out;
        options = setMenuOptions();
        this.userService = userService;
        this.bookService = bookService;
    }


    private List<String> setMenuOptions() {
        options = new ArrayList<>();
        options.add("List Books");
        options.add("List Movies");
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
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void showBookMenu() {
        output.print("ID:NAME:AUTHOR:YEAR");
        List<String[]> books = bookService.getBooks();
        for (String[] b : books) {
            String book = b[0]+":"+b[1]+":"+b[2]+":"+b[3];
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
        if(option == "0"){
            showBookMenu();
            return;
        }

    }

    private void showBookOptions() {
        output.print("0 . return book");
        output.print("1 . checkout book");
    }
}
