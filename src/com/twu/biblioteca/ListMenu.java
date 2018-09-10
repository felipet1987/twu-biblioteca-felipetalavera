package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;


public class ListMenu implements AppMenu {


    private static final String WELCOME = "Welcome";
    private final BookRepository repo;
    private List<Book> list;
    private List<String> menu;


    public ListMenu(BookRepository repo) {
        this.repo = repo;
        menu = setMenuOptions();


    }


    @Override
    public String start() {
        return WELCOME;
    }

    @Override
    public List<String[]> getBooks() {

        list = repo.getBookList();
        List<String[]> bookListView = BookListToView();
        return bookListView;
    }

    private List<String[]> BookListToView() {

        List<String[]> bookListView = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            if (!list.get(i).isCheckedOut()) {
                Book b = list.get(i);
                String[] bookDetails = {String.valueOf(b.getId()),b.getName(), b.getAuthor(), String.valueOf(b.getYear())};
                bookListView.add(bookDetails);
            }
        return bookListView;
    }


    @Override
    public String[] getMenu() {

        String[] menuView = new String[menu.size()];
        for (int i = 0; i < menu.size(); i++) {
            menuView[i] = menu.get(i);
        }
        return menuView;
    }

    private List<String> setMenuOptions() {
        menu = new ArrayList<>();
        menu.add("List Books");
        menu.add("List Movies");
        return menu;
    }

    @Override
    public boolean isValid(String option) {
        return menu.contains(option);
    }


    @Override
    public void returnBook(int id) throws Exception {

        if(repo.isCheckedOut(id)){
            repo.returnBook(id);
        }else{
            throw new Exception();
        }



    }

    @Override
    public void checkOutBook(int id) throws Exception {
        if(!repo.isCheckedOut(id)){
            repo.checkOutBook(id);
        }else{
            throw new Exception();
        }

    }

}
