package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookRepository implements BookRepository {




    @Override
    public List<Book> getBookList() {
        List<Book> list = new ArrayList<>();

        list.add(new Book(1,"Book 1","Author 1",2000,false));
        list.add(new Book(2,"Book 2","Author 1",2000,true));
        list.add(new Book(3,"Book 3","Author 1",2001,false));



        return list;
    }

    @Override
    public void returnBook(int id) {

    }

    @Override
    public void checkOutBook(int id) {

    }

    @Override
    public boolean isCheckedOut(int id) {
        return false;
    }
}
