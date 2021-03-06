package com.twu.biblioteca.mocks;

import com.twu.biblioteca.BookService;
import com.twu.biblioteca.globals;

import java.util.ArrayList;
import java.util.List;

public class FakeBookService implements BookService {
    @Override
    public List<String[]> getBooks() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"1","name","author","2000"});
        return list;
    }

    @Override
    public String checkout(int id) {
        if(id == 0){
            return globals.THAT_BOOK_IS_NOT_AVAILABLE;
        }
        return globals.THANK_YOU_ENJOY_THE_BOOK;
    }

    @Override
    public String returnBook(int id) {
        return globals.THANK_YOU_FOR_RETURNING_THE_BOOK;
    }

    @Override
    public int findByName(String name) {
        if(name == "nam"){
            return 1;
        }
        return 0;
    }

    @Override
    public List<String> showCheckoutBooks() {
        List<String> list = new ArrayList<>();
        list.add("1. book2");
        list.add("2. book3");
        return list;
    }
}
