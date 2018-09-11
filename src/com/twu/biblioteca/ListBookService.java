package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBookService implements BookService {
    private final BookRepository repo;

    public ListBookService(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<String[]> getBooks() {

        List<String[]> list = new ArrayList<>();
        List<Book> books = repo.getBookList();

        for (Book b: books) {
            if(b.isCheckedOut()){
                String[] bookDetails = {String.valueOf(b.getId()),b.getName(), b.getAuthor(), String.valueOf(b.getYear())};
                list.add(bookDetails);
            }
        }
        return list;
    }
}
