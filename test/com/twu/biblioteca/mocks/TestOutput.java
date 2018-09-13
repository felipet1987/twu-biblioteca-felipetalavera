package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class TestOutput implements OutputPort {

    private List<String> data;


    TestOutput() {
        data = new ArrayList<String>();
    }


    @Override
    public List<String> getOutput() {

        return this.data;
    }


    @Override
    public void print(String message) {
        this.data.add(message);
    }

}
