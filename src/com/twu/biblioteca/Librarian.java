package com.twu.biblioteca;

import java.util.List;

public class Librarian {


    private List<Book> bookList;

    public String sendWelcome() {
        return Constants.WELCOME_TO_BIBLIOTECA;
    }



    public String showBooks() {
        String message = "Id:Name:Author:Year\n";

        for (int i = 0; i <bookList.size() ; i++) {
            message += (i + 1) +":"+ bookList.get(i).toString()+"\n";
        }
        return message;
    }

    public void addBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
