package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

class Test2Repository implements BookRepository {

    private final ArrayList<Book> booklist;

    public Test2Repository() {

        booklist = new ArrayList<Book>();

        booklist.add(new Book(1, "Name1", "Author1", 2018, false));
        booklist.add(new Book(2, "Name2", "Author2", 2018, false));


    }

    @Override
    public List<Book> getBookList() {
        return booklist;
    }

    @Override
    public void returnBook(int id) {

    }

    @Override
    public void checkOutBook(int id) {
        find(id).checkOutBook();
    }

    @Override
    public boolean isCheckedOut(int id) {

        Book book = find(id);

        return book.isCheckedOut();
    }

    @Override
    public Book findBy(int id) {
        return null;
    }


    private Book find(int id) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getId() == id) {
                return booklist.get(i);
            }
        }
        return new Book(-1, "", "", -1, true);
    }
}
