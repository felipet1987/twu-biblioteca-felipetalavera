package com.twu.biblioteca;

import java.util.List;

public class GetBooksCmd {
    private final BookRepository repository;

    public GetBooksCmd(BookRepository repo) {
        this.repository = repo;
    }

    public String[][] execute() {


        List<Book> list = repository.getBookList();


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
}
