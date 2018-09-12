package com.twu.biblioteca.service;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.BookService;
import com.twu.biblioteca.globals;
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

        for (Book b : books) {
            if (b.isCheckedOut()) {
                String[] bookDetails = {String.valueOf(b.getId()), b.getName(), b.getAuthor(), String.valueOf(b.getYear())};
                list.add(bookDetails);
            }
        }
        return list;
    }

    @Override
    public String checkout(int id) {
        try {
            repo.checkOutBook(id);
            return globals.THANK_YOU_ENJOY_THE_BOOK;
        } catch (Exception e) {
            return globals.THAT_BOOK_IS_NOT_AVAILABLE;
        }
    }

    @Override
    public String returnBook(int id) {
        try {
            repo.returnBook(id);
            return globals.THANK_YOU_FOR_RETURNING_THE_BOOK;
        } catch (Exception e) {
            return globals.THAT_IS_NOT_A_VALID_BOOK_TO_RETURN;
        }
    }

    @Override
    public int findByName(String name) {
        return repo.findIdByName(name);
    }
}
