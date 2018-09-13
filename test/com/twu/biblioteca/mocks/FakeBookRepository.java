package com.twu.biblioteca.mocks;

import com.twu.biblioteca.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FakeBookRepository implements BookRepository {
    @Override
    public List<Book> getBookList() {


        List<Book> list = new ArrayList();
        list.add(new Book(1,"name","author",1,true));
        return list;
    }

    @Override
    public void returnBook(int id) throws Exception {
        if(id == 1){
            throw  new Exception();
        }

    }

    @Override
    public void checkOutBook(int id) throws Exception {
        if(id == 1){
            throw  new Exception();
        }

    }

    @Override
    public boolean isCheckedOut(int id) {
        return false;
    }

    @Override
    public Book findBy(int id) {
        return null;
    }

    @Override
    public int findIdByName(String name) {
        return 0;
    }
}
