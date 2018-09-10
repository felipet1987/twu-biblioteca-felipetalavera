package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

class TestRepository implements BookRepository {
    private ArrayList<Book> booklist;

    public TestRepository() {

        booklist = new ArrayList<>();

        booklist.add(new Book(1, "Name1", "Author1", 2018, false));
        booklist.add(new Book(2, "Name2", "Author2", 2018, true));


    }


    @Override
    public List<Book> getBookList() {

        return booklist;
    }

    @Override
    public void returnBook(int id) {

        Book book = find(id);

        book.returnBook();
        ;
    }

    @Override
    public void checkOutBook(int id) {

    }

    @Override
    public boolean isCheckedOut(int id) {
        return find(id).isCheckedOut();
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
