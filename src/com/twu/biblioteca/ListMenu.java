package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class ListMenu implements AppMenu {


    private static final String WELCOME = "Welcome";
    private final InputPort input;
    private final OutputPort output;
    private List<String> options;


    public ListMenu(InputPort in, OutputPort out) {
        this.input = in;
        this.output = out;
        options = setMenuOptions();
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
}
