package com.twu.biblioteca;

import com.twu.biblioteca.core.BookRepository;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookRepository implements BookRepository {


    private ArrayList<Book> books;

    public MemoryBookRepository() {
        books = new ArrayList<>();

        books.add(new Book(1, "Book 1", "Author 1", 2000, false));
        books.add(new Book(2, "Book 2", "Author 1", 2000, true));
        books.add(new Book(3, "Book 3", "Author 1", 2001, false));


    }

    @Override
    public List<Book> getBookList() {
        return books;
    }

    @Override
    public void returnBook(int id) throws Exception {
        Book b = findBy(id);
        if (b.isCheckedOut()) {
            b.returnBook();
        } else {
            throw  new Exception();
        }
    }

    @Override
    public void checkOutBook(int id) throws Exception{

        Book b = findBy(id);
        if(!b.isCheckedOut()){
            findBy(id).checkOutBook();
        }else{
            throw  new Exception();
        }


    }

    @Override
    public boolean isCheckedOut(int id) {
        return false;
    }

    @Override
    public Book findBy(int id) {
        for (Book b : books) {
            if(b.getId() == id){
                return b;
            }
        }
        return new Book(-1,"","",-1,true);
    }
}
