package com.twu.biblioteca.core;



import java.util.List;

public class MenuController {
    public static final String BOOK_HEADER = "ID:NAME:AUTHOR:YEAR";
    private final AppMenu menu;
    private final InputPort input;
    private final OutputPort output;

    public MenuController(AppMenu menu, InputPort input, OutputPort output) {
        this.menu =  menu;
        this.input = input;
        this.output = output;
    }

    public void showMenu() {

        output.clearScreen();

        String welcome = menu.start();

        String[] menuView = menu.getMenu();

        output.print(welcome);

        for (int i = 0; i < menuView.length; i++) {

            output.print(i +" . "+ menuView[i]);


        }


    }


    public void showBooks() {
        List<String[]> list = menu.getBooks();

        output.print(BOOK_HEADER);
        for (int i = 0; i <list.size(); i++) {
            String[] row = list.get(i);
            output.print(row[0]+":"+row[1]+":"+row[2]+":"+row[3]);

        }
        showBookOptions();

    }


    public void gotoOption() {
        output.print("choose an option");
        int option = input.getInt();
        if(option == 0){
            showBooks();
        }else{
            output.print("Invalid option");
            showMenu();
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
            output.print("Thank you! Enjoy the book");
        } catch (Exception e) {
            output.print("That book is not available.");

        }
    }

    public void returnBook() {
        int id = input.getInt();
        try {
            menu.returnBook(id);
            output.print("Thank you for returning the book.");
        } catch (Exception e) {
            output.print("That is not a valid book to return.");

        }
    }

    public void exit() {
        output.exit();
    }
}
