package com.twu.biblioteca;

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
        return null;
    }

    @Override
    public String returnBook(int id) {
        return null;
    }
}
