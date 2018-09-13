package com.twu.biblioteca.mocks;

import com.twu.biblioteca.OutputPort;

import java.util.ArrayList;
import java.util.List;

public class TestOutput implements OutputPort {

    private List<String> data;


    public TestOutput() {
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

    @Override
    public void exit() {

    }

}
