package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBookService implements BookService {
    public static final String THANK_YOU_ENJOY_THE_BOOK = "Thank you! Enjoy the book";
    public static final String THAT_BOOK_IS_NOT_AVAILABLE = "That book is not available.";
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
            return THANK_YOU_ENJOY_THE_BOOK;
        } catch (Exception e) {
            return THAT_BOOK_IS_NOT_AVAILABLE;
        }
    }
}
