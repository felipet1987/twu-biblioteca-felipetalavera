package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookMenu {



    public static final String WELCOME = "Welcome";
    private final BookRepository repo;
    private List<String> menu;

    public BookMenu(BookRepository repo) {
        this.repo = repo;
        menu = setMenuOptions();

    }

    public String start() {
        return WELCOME;
    }

    public String[][] getBookd() {
        List<Book> list = repo.getBookList();


        String[][] bookListView = BookListToView(list);
        return bookListView;
    }
    private String[][] BookListToView(List<Book> list) {
        String[][] bookListView = new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            bookListView[i][0] = String.valueOf(i);
            bookListView[i][1] = list.get(i).getName();
            bookListView[i][2] = list.get(i).getAuthor();
            bookListView[i][3] = String.valueOf(list.get(i).getYear());
        }
        return bookListView;
    }


    public String[] getMenu() {

        String[] menuView = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            menuView[i] = menu.get(i);
        }
        return menuView;
    }
    private List<String> setMenuOptions() {
        menu = new ArrayList<String>();
        menu.add("List Books");
        return menu;
    }

    public boolean isValid(String option) {
        return menu.contains(option);
    }
}
