package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookMenu {


    public static final String WELCOME = "Welcome";
    private final BookRepository repo;
    private final List<Book> list;
    private List<String> menu;

    public BookMenu(BookRepository repo) {
        this.repo = repo;
        menu = setMenuOptions();
        list = repo.getBookList();

    }

    public String start() {
        return WELCOME;
    }

    public List<String[]> getBooks() {


        List<String[]> bookListView = BookListToView();
        return bookListView;
    }

    private List<String[]> BookListToView() {

        List<String[]>  bookListView = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            if (!list.get(i).isCheckedOut()) {
                Book b = list.get(i);
                String[] bookDetails = {String.valueOf(i),b.getName(), b.getAuthor(), String.valueOf(b.getYear())};
                bookListView.add(bookDetails);
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
