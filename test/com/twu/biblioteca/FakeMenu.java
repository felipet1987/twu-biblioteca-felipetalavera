package com.twu.biblioteca;

import com.twu.biblioteca.core.AppMenu;

import java.util.ArrayList;
import java.util.List;

class FakeMenu implements AppMenu {
    @Override
    public String start() {
        return "Welcome";
    }

    @Override
    public List<String[]> getBooks() {
        List<String[]> bookList = new ArrayList<>();

        String[] book = {"1","name","author","2018"};
        bookList.add(book);
        return bookList;
    }

    @Override
    public String[] getMenu() {
        String[] menuView = new String[2];
        menuView[0] = "show available books";
        menuView[1] = "quit";
        return menuView;
    }

    @Override
    public boolean isValid(String option) {
        return false;
    }

    @Override
    public void returnBook(int id) throws Exception {
        if(id == 1){
            throw new Exception();
        }

    }

    @Override
    public void checkOutBook(int id) throws Exception {
        if(id == 1){
            throw new Exception();
        }

    }
}
