package com.twu.biblioteca;

import java.util.List;

public class Librarian {


    private List<Book> bookList;

    public String sendWelcome() {
        return Constants.WELCOME_TO_BIBLIOTECA;
    }



    public String bookListToString() {
        String message = "";
        for (int i = 0; i <bookList.size() ; i++) {
            message += (i + 1) + "," + bookList.get(i).getName() + "\n";
        }
        return message;
    }

    public void addBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
