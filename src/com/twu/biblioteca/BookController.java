package com.twu.biblioteca;

import java.util.List;

public class BookController {
    private final BookMenu menu;
    private final InputPort input;
    private final OutputPort output;

    public BookController(BookMenu menu, InputPort input, OutputPort output) {
        this.menu =  menu;
        this.input = input;
        this.output = output;
    }

    public void showMenu() {

        String welcome = menu.start();

        String[] menuView = menu.getMenu();

        output.print(welcome);

        for (int i = 0; i < menuView.length; i++) {

            output.print(i +" . "+ menuView[i]);


        }


    }


    public void showBooks() {
        List<String[]> list = menu.getBooks();

        output.print("ID:NAME:AUTHOR:YEAR");
        for (int i = 0; i <list.size(); i++) {
            String[] row = list.get(i);
            output.print(row[0]+":"+row[1]+":"+row[2]+":"+row[3]);

        }
    }


    public void gotoOption() {
        output.print("choose an option");
        int option = input.getInt();
        if(option == 0){
            showBooks();
        }
    }

    public void showBookOptions() {
        output.print("Choose an option");
        output.print("1 . return book");
        output.print("2 . checkout book");

    }

    public void checkout() {
        int id = input.getInt();
        try {
            menu.checkOutBook(id);
            output.print("Successful");
        } catch (Exception e) {
            output.print("Unsuccessful");

        }
    }
}
